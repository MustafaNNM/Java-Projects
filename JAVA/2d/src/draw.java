/**********************************************************************
        END OF THE WORLD PRODUCTION
        COPYRIGHT (C) 1997, PARTICLE
***********************************************************************/

import java.applet.*;
import java.awt.*;

public class draw extends Applet implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//thread support...
	Thread	 m_Pixel = null;

	private Graphics	secondGraphics=null;	

        private Image double_buffer=null;

        private	Panel controls=null;
	private int oldx,oldy;
	private Panel colors=null;
	private Button Red=null,Green=null,Blue=null;
	private Button Clear=null;
	private Button Yellow=null;
	private Button Original=null;
        private Button White=null;

        public draw()
	{
		// a useles constructor...
	}


	public void init()
	{
    	double_buffer = createImage(size().width, size().height);
		secondGraphics = double_buffer.getGraphics();	 
	//the layout part...	
		setLayout(new BorderLayout());
		controls=new Panel();
		controls.setLayout(new BorderLayout());

                

                colors=new Panel();
                White=new Button("White");
                colors.add(White);
                Yellow=new Button("Yellow");
		colors.add(Yellow);
		Red=new Button("Red");
		colors.add(Red);
		Green=new Button("Green");
		colors.add(Green);
		Blue=new Button("Blue");
		colors.add(Blue);
		Clear=new Button("Clear");
		colors.add(Clear);
		Original=new Button("Original");
		colors.add(Original);
		controls.add("North",colors);
		
		add("North",controls);
		colors.setForeground(Color.white);
		colors.setBackground(Color.black);
		controls.setForeground(Color.white);
		controls.setBackground(Color.black);
		setBackground(Color.black);
		setForeground(Color.yellow);
		resize(size().width,size().height);
		secondGraphics.setColor(Color.black);
		secondGraphics.fillRect(0,0,size().width,size().height);
		secondGraphics.setColor(Color.yellow);
	}


	public void destroy()
	{
		//again, nothing to do...
	}

	
	public void paint(Graphics g)
	{
		g.drawImage(double_buffer,0,0,this);
	}

        public void update(Graphics g)
        {
                paint(g);
        }

public void start()
	{
		//if thread does not exist, create a new one...
		if (m_Pixel == null){
			m_Pixel = new Thread(this);
			m_Pixel.start();	//make sure...
		}
	}
	

public void stop()
	{
		if (m_Pixel != null){
			m_Pixel = null;
			m_Pixel.stop();		 //make sure...
		}
	}


	public void run()
	{
		//got nothing to run... everything is event oriented.
	}

//check the buttons...	
public boolean action(Event evt,Object what){
			if(evt.target instanceof Button){
				// get first character of the string...		
				char first=((Button)evt.target).getLabel().charAt(0);
			 switch(first){
                         case 'W':      secondGraphics.setColor(Color.white);
                                        break;
                         case 'Y':	secondGraphics.setColor(Color.yellow);
					break;
			 case 'R':	secondGraphics.setColor(Color.red);
					break;
			 case 'G':	secondGraphics.setColor(Color.green);
					break;
			 case 'B':	secondGraphics.setColor(Color.blue);
					break;
			 case 'C':	secondGraphics.fillRect(0,0,size().width,size().height);
				 setBackground(secondGraphics.getColor());
				 repaint();
				 break;
			 case 'O':	
				 secondGraphics.setColor(Color.black);
				 secondGraphics.fillRect(0,0,size().width,size().height);
				 secondGraphics.setColor(Color.yellow);
				 setBackground(Color.black);
				 repaint();
				 break;
			 default:	break;
			 }
			 return true;
			}
		return false;
	}
	
//check the mouse...
public boolean mouseDown(Event evt, int x, int y)
	{
		oldx=x;
		oldy=y;
		return true;
	}

public boolean mouseDrag(Event evt, int x, int y)
	{
		secondGraphics.drawLine(oldx,oldy,x,y);
		repaint();
		oldx=x;
		oldy=y;
		return true;
	}
}
