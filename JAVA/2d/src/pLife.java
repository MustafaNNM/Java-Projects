/* 
 * pLife.java	v0.01	May 2, 1998
 *
 * The game of life!
 *
 * A very crude model!
 * (I just wanted to see how it would be <could not find 
 * the game elsewhere; so, just wrote one myself!>...)
 * 
 * Copyright(c) 1998, Particle
 */

import java.applet.*;
import java.awt.*;

/*
 * pLife, the Applet class
 */
public class pLife extends Applet implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//	m_pLife	is the Thread object for the applet
	private Thread	 m_pLife = null;

	//	double buffering.
	private Image double_buffer = null;
	private Graphics double_graphics = null;

    // Members for applet parameters
    // <type>       <MemberVar>    = <Default Value>
	private int m_xcells = 16;
	private int m_ycells = 16;

	private final String PARAM_xcells = "xcells";
	private final String PARAM_ycells = "ycells";
	private final String PARAM_speed = "speed";

	//	class data
	private int m_width;
	private int m_height;

	//	the number of bytes in m_cells
	private int m_size;

	//	pixels per cell
	private int m_xppc;
	private int m_yppc;

	//	cells
	private byte[] m_cells;
	private byte[] m_cells_tmp;

	//	timer (how fast generations are...)
	private int m_timer = 1000;

	// pLife Class Constructor
	public pLife(){
	}

	private int getBelow(int i){
		return (i+1) % m_ycells;
	}
	private int getAbove(int i){
		return (i-1 + m_ycells) % m_ycells;
	}
	private int getLeft(int i){
		return (i-1 + m_xcells) % m_xcells;
	}
	private int getRight(int i){
		return (i+1) % m_xcells;
	}
	public void cellInc(int x,int y,byte[] arr){
		byte c,b = arr[y*m_xcells+x];
		c = (byte)(b & 1);
		b >>= 1;
		if(b < 8)	
			b++;
		b <<= 1;
		b |= c;
		arr[y*m_xcells+x] = b;
	}
	
	public int getCount(int x,int y,byte[] arr){
		byte b = arr[y*m_xcells+x];
		b >>= 1;
		return (int)b;
	}

	public void cellDec(int x,int y,byte[] arr){
		byte c,b = arr[y*m_xcells+x];
		c = (byte)(b & 1);
		b >>= 1;
		if(b > 0)
			b--;
		b <<= 1;
		b |= c;
		arr[y*m_xcells+x] = b;
	}

	private void setCell(int x,int y,byte[] arr){
		if((arr[y*m_xcells+x] & 1) == 0){
			cellInc(getLeft(x),getAbove(y),arr);
			cellInc((x),getAbove(y),arr);
			cellInc(getRight(x),getAbove(y),arr);
			cellInc(getLeft(x),(y),arr);
			cellInc(getRight(x),(y),arr);
			cellInc(getLeft(x),getBelow(y),arr);
			cellInc((x),getBelow(y),arr);
			cellInc(getRight(x),getBelow(y),arr);
			arr[y*m_xcells+x] |= 1;
		}
	}

	private void clearCell(int x,int y,byte[] arr){
		if((arr[y*m_xcells+x] & 1) != 0){
			cellDec(getLeft(x),getAbove(y),arr);
			cellDec((x),getAbove(y),arr);
			cellDec(getRight(x),getAbove(y),arr);
			cellDec(getLeft(x),(y),arr);
			cellDec(getRight(x),(y),arr);
			cellDec(getLeft(x),getBelow(y),arr);
			cellDec((x),getBelow(y),arr);
			cellDec(getRight(x),getBelow(y),arr);
			arr[y*m_xcells+x] &= ~1;
		}
	}

	private void doGeneration(){
		int i,j,k;
		for(i=0;i<m_ycells;i++){
			for(j=0;j<m_xcells;j++){
				k = getCount(j,i,m_cells);
				if((m_cells[i*m_xcells+j] & 1) != 0){
					if(k < 2 || k > 3)
						clearCell(j,i,m_cells_tmp);
				}
				else if(k == 3)
						setCell(j,i,m_cells_tmp);
			}
		}
		System.arraycopy(m_cells_tmp,0,m_cells,0,m_size);
	}

	public void init(){
		String param;
		int i,j;

		// xcells: number of cells in x direction.
		param = getParameter(PARAM_xcells);
		if (param != null)
			m_xcells = Integer.parseInt(param);

		// ycells: number of cells in y direction
		param = getParameter(PARAM_ycells);
		if (param != null)
			m_ycells = Integer.parseInt(param);

		// speed: the speed of generations.
		param = getParameter(PARAM_speed);
		if (param != null)
			m_timer = Integer.parseInt(param);


		m_width = size().width;
		m_height = size().height;
		m_size = m_xcells * m_ycells;
		m_cells = new byte[m_size];
		m_cells_tmp = new byte[m_size];

		for(i = 0;i < m_ycells;i++){
			for(j = 0;j < m_xcells;j++){
				if(Math.random() > 0.5)
					setCell(j,i,m_cells_tmp);
			}
		}
		System.arraycopy(m_cells_tmp,0,m_cells,0,m_size);

		m_xppc = m_width/m_xcells;
		m_yppc = m_height/m_ycells;

		double_buffer = createImage(m_width,m_height);
		double_graphics = double_buffer.getGraphics();
	}

	/*
	 * draws the cells to a Graphics object
	 */
	private void drawCells(Graphics g){
		int i,j;
		for(i=0;i<m_ycells;i++){
			for(j=0;j<m_xcells;j++){
				if((m_cells[i*m_xcells+j] & 1) != 0)
					g.setColor(Color.blue);
				else
					g.setColor(Color.white);
				g.fillRect(j*m_xppc,i*m_yppc,(j+1)*m_xppc,(i+1)*m_yppc);
			}
		}
	}

	// pLife Paint Handler
	public void paint(Graphics g){
		drawCells(double_graphics);
		g.drawImage(double_buffer,0,0,null);
	}

	// pLife Update Handler
	public void update(Graphics g){
		paint(g);
	}

	// thread stuff...
	public void start(){
		if (m_pLife == null){
			m_pLife = new Thread(this);
			m_pLife.start();
		}
	}
	
	public void stop(){
		if (m_pLife != null){
			m_pLife.stop();
			m_pLife = null;
		}
	}

	/*
	 * main loop.
	 */
	public void run(){
		while (true){
			try{
				repaint();
				doGeneration();
				Thread.sleep(m_timer);
			}catch (InterruptedException e){
				stop();
			}
		}
	}

	/*
	 * for possible expansion of this prog... 
	 * (to let people draw stuff, and then simulate it!)
	 */
	public boolean mouseDown(Event evt, int x, int y){
		return true;
	}

	public boolean mouseUp(Event evt, int x, int y){
		return true;
	}
}
