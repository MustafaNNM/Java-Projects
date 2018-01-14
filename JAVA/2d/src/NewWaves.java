/*
 * NewWaves.java
 *
 * Copyright(c) 2001, Particle Corporation
 * All Rights Reserved
 */

import java.awt.*;
import java.applet.*;
import java.awt.image.*;

/**
 * NewWaves applet
 *
 * @author Alex S.
 * @version 1.1.0
 */
public class NewWaves extends Applet implements Runnable, ImageProducer {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// a running thread for this applet
    private Thread m_thread;

    // track loading of images
    private MediaTracker tracker;

    // image object. this is the one we load from server
    private Image image_object;

    // this is a corresponding data buffer for image_object
    private int[] image_buffer;

    // double image is the viewing area represented as an image
    private Image double_image;

    // this is the viewing area represented as a data buffer. it is blited onto double_image
    private int[] double_buffer;

    // dimensions of the viewing area (not loaded image)
    private int m_width,m_height;

    // color model for our image producer
    private ColorModel color_model;

    // image producer has to have an image consumer
    private ImageConsumer consumer = null;

    // transforms for our wave
    private int[] sin_x_table = null;
    private int[] sin_y_table = null;
    int xcounter = 0;
    int ycounter = 0;

    /**
     * constructor to init some basic things
     */
    public NewWaves(){
        m_thread = null;
        image_object = null;
        image_buffer = null;
        double_buffer = null;
        tracker = null;
    }

    /**
     * init method, called by applet container to init applet
     */
    public void init(){
        // initialize media tracker to this component
        tracker = new MediaTracker(this);

        // get image
        String param;
        param = getParameter("img");
        image_object = getImage(getDocumentBase(),param);

        // track image
        tracker.addImage(image_object,0);

        // get dimensions
        m_width = size().width;
        m_height = size().height;

        // setup image producer attributes & double buffer
        color_model = new DirectColorModel(32,0xFF0000,0x00FF00,0x0000FF);
        double_buffer = new int[m_width*m_height];
        double_image = createImage(this);

        // init the wave transforms

        int i;
        sin_x_table = new int[m_width*2];
        sin_y_table = new int[m_height*2];

        for (i=0;i<m_width;i++)
            sin_x_table[i] = (int)(Math.sin(i * 6.28/m_width) * 10);
        for (;i<m_width*2;i++)
            sin_x_table[i] = sin_x_table[i-m_width];
        for (i=0;i<m_height*2;i++)
            sin_y_table[i] = (int)(Math.sin(i * 6.28/m_height) * 10);
        for (;i<m_height;i++)
            sin_y_table[i] = sin_y_table[i-m_height];

    }

    /**
     * starts a new thread of this applet
     */
    public void start() {
        if(m_thread == null){
            m_thread = new Thread(this);
            m_thread.start();
        }
    }

    /**
     * nulls out thread, making it possible for gc to get rid of it
     */
    public void stop() {
        m_thread = null;
    }

    /**
     * method to draw the scene and handle loading of images
     */
    public void draw_scene(){

        // are all the images loaded?
        if (tracker.checkAll(true)) {

            // did we already create the image buffer
            if (image_buffer == null) {

                // create image buffer
                image_buffer = new int[m_width * m_height];
                int w = image_object.getWidth(this);
                int h = image_object.getHeight(this);
                if (w > m_width)
                    w = m_width;
                if (h > m_height)
                    h = m_height;

                // get image pixels and store them in the image buffer
                PixelGrabber pg = new PixelGrabber(image_object,0,0,w,h,image_buffer,0,m_width);
                try {
                    pg.grabPixels();
                } catch (InterruptedException e) {
                    return;
                }
            } else {

                // using the wave transforms, copy the image buffer to the
                // display buffer. The result will look like a waved version
                // of the image buffer.

                int x,y,tx,ty;
                xcounter = xcounter > (m_width-10) ? 0:xcounter+9;
                ycounter = ycounter > (m_height-6) ? 0:ycounter+5;
                for (y=0;y<m_height;y++)
                    for (x=0;x<m_width;x++) {
                        tx = x + sin_y_table[y + ycounter];
                        ty = y - sin_x_table[x + xcounter];
                        tx = tx < 0 ? -tx:tx;
                        ty = ty < 0 ? -ty:ty;
                        tx %= m_width;
                        ty %= m_height;
                        double_buffer[y*m_width+x] = image_buffer[ty*m_width+tx];
                    }
            }

        }
    }

    /**
     * runs thread
     */
    public void run(){
        // wait for images (this starts download if it hasn't already begun)
        try {
            tracker.waitForID(0);
        } catch (InterruptedException e) {
            return;
        }

        // look forever
        for (;;) {

            // draw things to double buffer
            draw_scene();

            // paint double buffer to display area
            repaint();

            // let other threads have some air
            Thread.yield();

            // sleep (this applet tends to run too fast on some machines)
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    /**
     * we don't need the default update() to clear the display area
     */
    public void update(Graphics g) {
        paint(g);
    }

    /**
     * call blit(), and draw the image produced by the image producer
     */
    public void paint(Graphics g) {
        blit();
        g.drawImage(double_image, 0, 0, null);
    }


    /**
     * one of image producer interfaces; to add image consumer
     * note: we only have 1 image consumer
     */
    public void addConsumer(ImageConsumer ic){
        if (consumer != ic) {
            consumer =  ic;
            consumer.setDimensions(m_width,m_height);
            consumer.setColorModel(color_model);
            consumer.setHints(ImageConsumer.TOPDOWNLEFTRIGHT);
        }
        blit();
    }

    /**
     * image producer interface
     */
    public boolean isConsumer(ImageConsumer ic){
        return ic == consumer;
    }

    /**
     * image producer interface
     */
    public void removeConsumer(ImageConsumer ic){}

    /**
     * image producer interface.
     * this is called when image consumer wants data
     */
    public void startProduction(ImageConsumer ic){
        addConsumer(ic);
    }

    /**
     * image consumer requests a resend. just ignore it.
     */
    public void requestTopDownLeftRightResend(ImageConsumer ic){}

    /**
     * blit writes the double buffer pixels into the image consumer
     */
    void blit(){
        if (consumer != null) {
            consumer.setPixels(0,0,m_width,m_height,
                               color_model,double_buffer,0,m_width);
        }
    }
}

