/*
 * scroller.java	February 21, 1998
 * 
 * Copyright (c) 1998, Particle
 */
import java.applet.*;
import java.awt.*;

public class scroller extends Applet implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Thread	 m_scroller = null;

	private int m_mouse_x = 0;
	private int m_mouse_y = 0;

	private Color m_cfgcolor = Color.black;
	private Color m_cbgcolor = Color.white;
	private Color m_cshadow = Color.gray;

	private int m_speed = 2;
	private String m_string = "Use a 'string' parameter to specify a string...";
	private String m_font = "Courier";
	private String m_style = "PLAIN";
	private int m_size = 12;
	
	private int m_inc = 1;

	private int m_nOffset;
	private int m_nMax;
	private int m_nMin;
	private int m_string_height;

	private Image m_image;
	private Graphics m_g;

	public void init()
	{
		String param;

		param = getParameter("fgcolor");
		if (param != null)
			m_cfgcolor = new Color(Integer.parseInt(param,16));
		setForeground(m_cfgcolor);

		param = getParameter("bgcolor");
		if (param != null)
			m_cbgcolor = new Color(Integer.parseInt(param,16));
		setBackground(m_cbgcolor);
		
		param = getParameter("shadow");
		if (param != null)
			m_cshadow = new Color(Integer.parseInt(param,16));
		
		param = getParameter("speed");
		if (param != null)
			m_speed = Integer.parseInt(param);

		param = getParameter("string");
		if (param != null)
			m_string = param;

		param = getParameter("font");
		if (param != null)
			m_font = param;

		param = getParameter("style");
		if (param != null)
			m_style = param;

		param = getParameter("size");
		if (param != null)
			m_size = Integer.parseInt(param);

		int nStyle = Font.PLAIN;
		if(m_style.equalsIgnoreCase("BOLD"))
			nStyle = Font.BOLD;
		if(m_style.equalsIgnoreCase("ITALIC"))
			nStyle = Font.ITALIC;
		Font font = new Font(m_font,nStyle,m_size);

		FontMetrics fm = getFontMetrics(font);
		m_nMin = -fm.stringWidth(m_string);
		m_string_height = fm.getAscent() + fm.getDescent();
		m_nMax = size().width;
		m_nOffset = m_nMax;

		m_image = createImage(size().width,size().height);
		m_g = m_image.getGraphics();
		m_g.setFont(font);
	}

	public void paint(Graphics g)
	{
		if(m_image != null)
			g.drawImage(m_image,0,0,null);
	}

	public void update(Graphics g)
	{	
		m_g.setColor(m_cbgcolor);
		m_g.fillRect(0,0,size().width,size().height);
		
		m_g.setColor(m_cshadow);
		m_g.drawString(m_string,m_nOffset+1,m_string_height+1);
		
		m_g.setColor(m_cfgcolor);
		m_g.drawString(m_string,m_nOffset,m_string_height);
		paint(g);
	}

	public void start()
	{
		if (m_scroller == null){
			m_scroller = new Thread(this);
			m_scroller.start();
		}
	}
	
	public void stop()
	{
		if (m_scroller != null){
			m_scroller.stop();
			m_scroller = null;
		}
	}

	public void run()
	{
		int nSleepValue = 1000/m_speed;
		while (true){
			try{
				m_nOffset-=m_inc;
				if(m_nOffset < m_nMin)
					m_nOffset = m_nMax;
				repaint();
				Thread.sleep(nSleepValue);
			}catch (InterruptedException e){
				stop();
			}
		}
	}

	public boolean mouseDown(Event evt, int x, int y)
	{
		m_inc = 0;
		m_mouse_x = x;
		setM_mouse_y(y);
		return true;
	}

	public boolean mouseUp(Event evt, int x, int y)
	{
		m_inc = 1;
		m_mouse_x = x;
		setM_mouse_y(y);
		return true;
	}

	public boolean mouseDrag(Event evt, int x, int y)
	{
		m_nOffset += x - m_mouse_x;
		if(m_nOffset < m_nMin)
			m_nOffset = m_nMax;	
		if(m_nOffset > m_nMax)
			m_nOffset = m_nMin;
		m_mouse_x = x;
		setM_mouse_y(y);
		return true;
	}

	public int getM_mouse_y() {
		return m_mouse_y;
	}

	public void setM_mouse_y(int m_mouse_y) {
		this.m_mouse_y = m_mouse_y;
	}
}
