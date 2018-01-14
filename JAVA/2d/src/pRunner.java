/*
 * pRunner.java
 *
 * Copyright(c) 2001, Particle
 * All Rights Reserved.
 */

import java.applet.*;
import java.awt.*;
import java.io.*;
import java.net.URL;

/**
 * a model class. Loads model, and provides frames
 *
 * Revised version. Allows for viewing while finishing download of model.
 *
 * uses PMF (Particle Model Format ;-)
 */
class PMF_Model implements Runnable {

    private int num_triangles;
    private int num_vertices;
    private int num_frames;

    private int num_frames_loaded;

    short[][] triangles;
    float[][][] frames;

    DataInputStream dis;

    public PMF_Model(InputStream is) throws IOException {
        int i,j,k;
        dis = new DataInputStream(is);

        byte[] type = new byte[4];
        dis.readFully(type);

        int version = dis.readShort();

        num_triangles = dis.readShort();
        num_vertices = dis.readShort();
        num_frames = dis.readUnsignedByte();
        triangles = new short[num_triangles][3];
        frames = new float[num_frames][num_vertices][4];
        num_frames_loaded = 0;

        // read the rest of the file in a concurrent thread
        Thread t = new Thread(this);
        t.start();
    }

    public void run(){
        try {
            int i,j,k;
            for (i=0;i<num_triangles;i++)
                for (j=0;j<3;j++) {
                    int b1 = dis.readUnsignedShort();
                    triangles[i][j] = (short)b1;
                }

            float[] scale = new float[3];
            float[] trans = new float[3];
            for (i=0;i<num_frames;i++) {
                for (j=0;j<3;j++)
                    scale[j] = dis.readFloat();
                for (j=0;j<3;j++)
                    trans[j] = dis.readFloat();
                for (j=0;j<num_vertices;j++) {
                    for (k=0;k<3;k++)
                        frames[i][j][k] = dis.readUnsignedByte() * scale[k] + trans[k];
                    frames[i][j][3] = 1;
                }
                num_frames_loaded = i;
            }
            num_frames_loaded = i;
        } catch (IOException e) {
            // just let it fail...
        }
    }

    public int getNumTriangles(){
        return num_triangles;
    }
    public int getNumVertices(){
        return num_vertices;
    }
    public int getNumFrames(){
        return num_frames_loaded;
        // return num_frames;
    }
    public int getMaxNumFrames(){
        return num_frames;
    }

    public short[][] getTriangles(){
        return triangles;
    }

    public float[][] getFrame(int f){
        return frames[f];
    }
}



public class pRunner extends Applet implements Runnable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Thread m_thread;

    private PMF_Model m_model;

    private int m_width,m_height;

    // support for float buffer
    private Image m_image;
    private Graphics m_g;

    // angle, mouse state
    private float m_anglex,m_angley;
    private int m_mousex,m_mousey;

    int currentFrame;
    int maxFrames;
    int numPoints;

    float[][] point0;
    float[][] point1;
    float[][] point2;

    short[][] faces0;

    float[][] m1 = new float[4][4];
    float[][] m2 = new float[4][4];

    boolean animating = true;


    public void init() {
        String param = getParameter("model");
        try {
            m_model = new PMF_Model((new URL(getDocumentBase(),param)).openStream());
            //m_model = new PMF_Model(ClassLoader.getSystemResourceAsStream(param));

        } catch (IOException e) {
            System.out.println(e.toString());
        }

        currentFrame = 0;
        numPoints = m_model.getNumVertices();

        faces0 = m_model.getTriangles();

        // buffer
        point1 = new float[numPoints][4];
        point2 = new float[numPoints][4];


        m_width = size().width;
        m_height = size().height;

        // init angle + mouse
        m_mousex = m_mousey = 0;
        m_anglex = (float)(Math.PI/2);
        m_angley = (float)(Math.PI+Math.PI/2);

        // init float buffer
        m_image = createImage(m_width,m_height);
        m_g = m_image.getGraphics();



    }

    /**
     * starts a new thread of this applet
     */
    public void start() {
        if (m_thread == null) {
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
     * runs thread
     */
    public void run(){

        // look forever
        for (;;) {

            repaint();

            if (animating) {
                currentFrame++;
                if (currentFrame >= m_model.getNumFrames())
                    currentFrame = 0;
            }
            // let other threads have some air
            Thread.yield();
            // sleep (this applet tends to run too fast on some machines)
            try {
                m_thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }
        }
    }



    public int comparePointsByZ(short[] a,short[] b,float[][] p){

        // find middle z of faces
        float ax,bx;
        int i;
        ax = 0;
        for (i=0;i<a.length;i++) {
            ax+=p[a[i]][2];
        }
        ax /= a.length;
        bx = 0;
        for (i=0;i<b.length;i++) {
            bx += p[b[i]][2];
        }
        bx /= b.length;

        // compare them
        if (ax > bx)
            return 1;
        else if (ax < bx)
            return -1;
        return 0;
    }

    public void sortFacesByZ(short[][] a,float[][] p){

        int i,j;
        short[] e;
        for (i=1;i<a.length;i++) {
            e = a[i];
            for (j=i-1;j>=0 && comparePointsByZ(a[j],e,p) > 0;j--)
                a[j+1] = a[j];
            a[j+1] = e;
        }

    }


    // paint
    public void paint(Graphics g){


        if (m_model.getNumFrames() == 0) {
            // if no frames are loaded yet, clear with dark gray
            m_g.setColor(Color.lightGray);
            m_g.fillRect(0,0,m_width,m_height);
            m_g.setColor(Color.black);
            m_g.drawString("Loading First Frame",100,100);
            // blit float buffer into primary buffer
            g.drawImage(m_image,0,0,null);
            return;
        } else {
            // clear screen (in float buffer)
            m_g.setColor(Color.white);
        }
        m_g.fillRect(0,0,m_width,m_height);
        m_g.setColor(Color.black);
        m_g.drawString (currentFrame+"/"+m_model.getMaxNumFrames(),10,10);

        if (m_model.getMaxNumFrames() != m_model.getNumFrames()) {
            m_g.drawString ("loaded "+m_model.getNumFrames()+"/"+m_model.getMaxNumFrames()+" frames",10,20);
        }

        clearMatrix(m1);

        // scale cube
        scaleMatrix(m1,3,m2);

        // rotate it (using the angles)
        rotateMatrixX(m2,m_anglex,m1);
        rotateMatrixY(m1,m_angley,m2);

        // translate it away from the origin
        translateMatrix(m2,0,0,-200,m1);

        point0 = m_model.getFrame(currentFrame);

        // trnansform all points in the cube using the matrix
        for (int i=0;i<point0.length;i++) {
            transformVertex(m1,point0[i],point1[i]);
        }

        // prepare perspective transform matrix
        projectPerspectiveMatrix(m_width,-1,m2);

        // Z-sort faces
        sortFacesByZ(faces0,point1);

        // for all faces
        for (int i=0;i<faces0.length;i++) {
            short[] face = faces0[i];

            // get the plane equation of the transformed face
            float[] plane = new float[4];
            planeFromPoints(plane,point1[face[0]],point1[face[1]],point1[face[2]]);
            float d = plane[3];

            // if the face is facing us ;-)
            if (d > 0) {

                // prepare params for java's fill poly
                int[] x = new int[face.length];
                int[] y = new int[face.length];

                // apply perspective transform, and move to center of viewing area
                for (int j=0;j<face.length;j++) {

                    transformVertex(m2,point1[face[j]],point2[face[j]]);
                    point2[face[j]][0] /= point2[face[j]][3];
                    point2[face[j]][1] /= point2[face[j]][3];
                    point2[face[j]][2] /= point2[face[j]][3];

                    x[j] = (int)point2[face[j]][0];
                    x[j] += m_width/2;
                    y[j] = (int)point2[face[j]][1];
                    y[j] += m_height/2;
                }

                // create face color (using it's angle to view plane)
                int color = (int)(50 + d);
                if (color > 0xFF)
                    color = 0xFF;

                // set color for fill
                m_g.setColor(new Color(color,
                                       color,
                                       color));
                // fill poly
                m_g.fillPolygon(x,y,face.length);

                // draw borders, and vertex numbers.
                //                      m_g.setColor(Color.gray);
                //                      m_g.drawPolygon(x,y,face.length);

            }

        }



        // blit float buffer into primary buffer
        g.drawImage(m_image,0,0,null);
    }

    // is called asynchronously when redraw() is called
    public void update(Graphics g){
        paint(g);
    }


    void transformVertex(float[][] m,float[] s,float[] d){
        int i,j;
        for (i=0;i<4;i++) {
            d[i] = 0;
            for (j=0;j<4;j++)
                d[i] += m[i][j] * s[j];
        }
    }

    void crossProductMatrix(float[][] s1,float[][] s2,float[][] d){
        int i,j,k;
        for (i=0;i<4;i++) {
            for (j=0;j<4;j++) {
                d[i][j] = 0;
                for (k=0;k<4;k++)
                    d[i][j] += s1[i][k] * s2[k][j];
            }
        }
    }

    void scaleMatrix(float[][] s1,float s,float[][] d){
        float[][] s2 = new float[4][4];
        int i,j;
        for (i=0;i<4;i++)
            for (j=0;j<4;j++)
                s2[i][j] = (i == j) ? s:0;
        s2[3][3] = 1;
        crossProductMatrix(s2,s1,d);
    }

    void translateMatrix(float[][] s1,float x,float y,float z,float[][] d){
        float[][] s2 = new float[4][4];
        clearMatrix(s2);
        s2[0][3] = x;
        s2[1][3] = y;
        s2[2][3] = z;
        crossProductMatrix(s2,s1,d);
    }

    void rotateMatrixX(float[][] s1,float a,float[][] d){
        float[][] s2 = new float[4][4];
        clearMatrix(s2);
        float sin = (float)Math.sin(a);
        float cos = (float)Math.cos(a);
        s2[1][1] = cos;         s2[1][2] = -sin;
        s2[2][1] = sin;         s2[2][2] = cos;
        crossProductMatrix(s2,s1,d);
    }

    void rotateMatrixY(float[][] s1,float a,float[][] d){
        float[][] s2 = new float[4][4];
        clearMatrix(s2);
        float sin = (float)Math.sin(a);
        float cos = (float)Math.cos(a);
        s2[0][0] = cos;         s2[0][2] = sin;
        s2[2][0] = -sin;        s2[2][2] = cos;
        crossProductMatrix(s2,s1,d);
    }

    // create perspective
    void projectPerspectiveMatrix(float zprp,float zvp,float[][] d){
        clearMatrix(d);
        float d1 = zprp - zvp;
        d[2][2] = -zvp/d1;      d[2][3] = zvp*(zprp/d1);
        d[3][2] = -1/d1;        d[3][3] = zvp/d1;
    }


    void clearMatrix(float[][] d){
        int i,j;
        for (i=0;i<4;i++)
            for (j=0;j<4;j++)
                d[i][j] = (i == j) ? 1:0;
    }

    // print matrix for debug purposes
    void printMatrix(float[][] d){
        int i,j;
        for (i=0;i<4;i++) {
            for (j=0;j<4;j++)
                System.out.print(d[i][j]+" ");
            System.out.println("");
        }
        System.out.println("");
    }

    void vectorSubtract (float[] va, float[] vb, float[] out){
        out[0] = va[0]-vb[0];
        out[1] = va[1]-vb[1];
        out[2] = va[2]-vb[2];
    }

    // cross product of two vectors
    void crossProduct(float[] v1, float[] v2, float[] cross ) {
        cross[0] = v1[1]*v2[2] - v1[2]*v2[1];
        cross[1] = v1[2]*v2[0] - v1[0]*v2[2];
        cross[2] = v1[0]*v2[1] - v1[1]*v2[0];
    }

    float vectorNormalize(float[] in, float[] out ) {
        float   length, ilength;
        length = (float)Math.sqrt(in[0]*in[0] + in[1]*in[1] + in[2]*in[2]);
        if (length == 0) {
            return 0;
        }
        ilength = (float)(1.0/length);
        out[0] = in[0]*ilength;
        out[1] = in[1]*ilength;
        out[2] = in[2]*ilength;
        return length;
    }

    float dotProduct (float[] v1, float[] v2){
        return v1[0]*v2[0] + v1[1]*v2[1] + v1[2]*v2[2];
    }

    // gets plane equation from three points on plane
    boolean planeFromPoints(float[] plane, float[] a, float[] b,float[] c ) {
        float[] d1 = new float[4];
        float[] d2 = new float[4];
        vectorSubtract( b, a, d1 );
        vectorSubtract( c, a, d2 );
        crossProduct( d2, d1, plane );
        if ( vectorNormalize( plane, plane ) == 0 ) {
            return false;
        }
        plane[3] = dotProduct( a, plane );
        return true;
    }

    public boolean mouseDown(Event evt, int x, int y){
        animating = false;
        return true;
    }

    public boolean mouseUp(Event evt, int x, int y) {
        animating = true;
        return true;
    }

    // mouse event handler
    public boolean mouseDrag(Event evt, int x, int y){
        if ((m_mousey - y) < 0)
            m_anglex += Math.PI/45;
        if ((m_mousey - y) > 0)
            m_anglex -= Math.PI/45;

        if ((m_mousex - x) < 0)
            m_angley -= Math.PI/45;
        if ((m_mousex - x) > 0)
            m_angley += Math.PI/45;
        m_mousex = x;
        m_mousey = y;

        // update screen with new angles
        repaint();

        return true;
    }

}
