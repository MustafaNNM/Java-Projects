/**************************************************************
        END OF THE WORLD PRODUCTION
        COPYRIGHT (C) 1997-1998, PARTICLE

        Permission to use & distribute for FREE if
        and only if some credit is given to Particle.

        I AM NOT RESPONSIBLE FOR ANYTHING

        -- Particle --
***************************************************************/

import java.applet.*;
import java.awt.*;
import java.awt.image.*;
import java.lang.*;
import java.util.*;

public class scale extends Applet implements Runnable
{
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		/* thread support */
        Thread	myStringThread = null;

	  private Image image = null;
	  private String imageFile = null;

        Image double_buffer = null;
        Graphics double_graphics = null;

        /* the speed with whitch the message scrolls */
        private int Speed;

        /* the width and height of the applet */
        private int width,height;

        /* colors for foreground, background, and shadow (secondfgcolor).*/
        Color bgcolor=null,fgcolor=null;
        int x1,y1,x2,y2;
        int x1_inc,y1_inc,x2_inc,y2_inc;
/***************************************************************
Initialize the applet, get it ready to run.
****************************************************************/
public void init(){
                /* temp String to help extract parameters */
        String parameterGot = null;

                /* for what each parameter does, see
                the getParameterInfo() function */

        if((parameterGot=getParameter("width"))==null)
                width = this.size().width;
        else    width = Integer.valueOf(parameterGot,10).intValue();

        if((parameterGot=getParameter("height"))==null)
             height = this.size().height;
        else height=Integer.valueOf(parameterGot,10).intValue();

        if((parameterGot=getParameter("speed"))==null)
             Speed = 2;
        else Speed=Integer.valueOf(parameterGot,10).intValue();

        if((parameterGot=getParameter("fgcolor"))==null)
             fgcolor = Color.black;
        else fgcolor=new Color(Integer.valueOf(parameterGot,16).intValue());

        if((parameterGot=getParameter("bgcolor"))==null)
             bgcolor = Color.white;
        else bgcolor=new Color(Integer.valueOf(parameterGot,16).intValue());

	  if((parameterGot=getParameter("img"))==null)
             imageFile = parameterGot;
        else imageFile = new String("q.jpg");

                /* resize it to exactly that size */
        resize(width,height);

        x1 = y1 = 0;
        x1_inc = y1_inc = x2_inc = y2_inc = Speed;
        x2 = width;
        y2 = height;

	image = getImage(getDocumentBase(),imageFile);

        double_buffer = createImage(width,height);
        double_graphics = double_buffer.getGraphics();

        double_graphics.setColor(bgcolor);

        double_graphics.fillRect(0,0,width,height);

                /* set the applet's foreground and background
                colors.  we don't want it to flicker.. do we? */
        setBackground(bgcolor);
        setForeground(fgcolor);
}



/******************************************************************
start the applet's thread
*******************************************************************/
public void start(){
		if (myStringThread == null){
                       //checks for previous instances...
			myStringThread = new Thread(this);
			myStringThread.start();
		}	
}

/******************************************************************
stop the thread
*******************************************************************/
public void stop(){
		if (myStringThread != null){
			myStringThread.stop();
			myStringThread = null;
		}
}


public void paint(Graphics g){
	        /* start by drawing out work place
                        to the actual physical graphics screen */
        g.drawImage(double_buffer,0,0,this);
}

/**
 * just call paint(Graphics);
 */
public void update(Graphics g){
        paint(g); 
}

/******************************************************************
*******************************************************************/
public synchronized void run(){
        int tmp;
                /* do forever */
        while(true){

                x1+=x1_inc;
                y1+=y1_inc;
                x2+=x2_inc;
                y2+=y2_inc;

                if(x1 > width)
                        x1_inc = -Speed;
                else if(x1 < 0)
                        x1_inc = Speed;
                if(y1 > height)
                        y1_inc = -Speed;
                else if(y1 < 0)
                        y1_inc = Speed;
                if(x2 > width)
                        x2_inc = -Speed;
                else if(x2 < 0)
                        x2_inc = Speed;
                if(y2 > height)
                        y2_inc = -Speed;
                else if(y2 < 0)
                        y2_inc = Speed;

                /* this is to prevent the image from flipping...

                        Flipping works OK on the JDK, but Netscape
                        can't handle it, and does nothing, IE4
                        just avoids flipping by drawing a black
                        rectrangle where an image should be...
                        (great java compatibility ... huh?)
                */
                if(x1 > x2){
                        tmp = x1;
                        x1 = x2;
                        x2 = tmp;
                        tmp = x1_inc;
                        x1_inc = x2_inc;
                        x2_inc = tmp;
                }
                if(y1 > y2){
                        tmp = y1;
                        y1 = y2;
                        y2 = tmp;
                        tmp = y1_inc;
                        y1_inc = y2_inc;
                        y2_inc = tmp;

                }

                /* try to "prevent" flickering.... again, works fine
                under JDK, but flickers under IE... is it me, or does
                IE seems to suck?

                ps: screw Netscape as well for not even having this
                    method!
                */

                double_graphics.drawImage(image,x1,y1,x2,y2,
                        0,0,image.getWidth(this),image.getHeight(this),this);

                repaint();
                try{
                       Thread.sleep(15);
                }
                catch (InterruptedException e){
                        stop();
                }
        }
   }
}

/***************************************************************************
        END OF THE WORLD PRODUCTION
        COPYRIGHT (C) 1997, PARTICLE
****************************************************************************/

