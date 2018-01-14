/*
 * queens.java		v0.01	November 8th, 1998
 *
 * An applet to go through all the possible combinations
 * of an 8-queen poblem (solve it).
 *
 * There are 92 solutions.
 *
 * the applet quickly goes though ALL the combinations, filling
 * in the solutions list, and then suspends the "solving" thread.
 *
 * the user can click on the solutions list, and view them in the
 * view area. If they wish, they can continue the solving thread,
 * and see how it actually goes though all the solutions.
 * 
 * License Agreement: You are given permission to use this code
 * for watever purpose you like, you must however give Particle
 * credit whenever it's used, and you cannot sell it! (e-mail the
 * author at bsptree at NO SPAM geocities dot com for more info)
 *
 * This code also follows: The author is not responsible for
 * ANYTHING the code does! If it's bad, don't blame me, if it's
 * good, thank me.
 * 
 * Copyright(c) 1998, Particle
 */

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
 * queensCanvas
 *
 * The Canvas class for the queens, this one just pre-renders
 * the chess board, so that all the user has to worry about is
 * tellling it what to draw... (and where)
 */
class queensCanvas extends Canvas{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public byte[] board = null;

	public void setWhatToDraw(byte[] b){
		board = b;
		repaint();
	}

	public queensCanvas(){
		setSize(128,128);	/* size is 128 x 128 */		
		setVisible(true);
		repaint();
	}

	public void update(Graphics g){
	 	paint(g);
	}
	
	public void paint(Graphics g){
		for(int y = 0;y < 8;y++){
			for(int x = 0;x<8;x++){
				if(((x % 2) ^ (y % 2)) == 0)
					g.setColor(Color.white);
				else
					g.setColor(Color.black);
				if(board != null && board[x] == y)
					g.setColor(Color.blue);
				g.fillRect(x<<4,y<<4,16,16);
			}
		}
	}
}

/*
 * queens
 *
 * the heart class of the applet. This is the one
 * that finds all the solutions, and makes the canvas
 * class produce the output.
 *
 * the search is actually a LOT faster than the applet
 * makes it seem... I made it this way so that It would
 * be possible to actually see the results... 
 * simply remove the Thread.sleep() out of the find8queens()
 * method, and the program will fly.
 *
 * Copyright(c) 1998, Particle
 */
public class queens extends Applet implements Runnable,
	ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Thread	m_queens = null;

	private queensCanvas	m_processwindow = null;
	private queensCanvas	m_viewwindow = null;
	private Button	m_stopbutton = null;
	private Button	m_continuebutton = null;
	private Button	m_viewbutton = null;
	private List		m_viewlist = null;
	private Label	m_solutioncount = new Label("  ");
	private int		m_sleeptime = 2;
	private boolean m_already_ran = false;

	/**
	 * does anybody use these things?
	 */
	public String getAppletInfo(){
		return "Name: queens\r\n" +
		       "Author: Particle (Copyright(c) 1998, Particle)\r\n" +
		       "Created with JDK Version 1.2 RC1";
	}

	/**
	 * initialize the interfrace
	 */
	public void init(){
		m_processwindow = new queensCanvas();
		m_viewwindow = new queensCanvas();
		m_stopbutton = new Button("Stop");
		m_stopbutton.addActionListener(this);
		m_continuebutton = new Button("Continue");
		m_continuebutton.addActionListener(this);
		m_viewlist = new List(8,false);
		m_viewbutton = new Button("View");
		m_viewbutton.addActionListener(this);
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setLayout(gridbag);
		Label label = new Label("Process");
		c.gridx = 0;
		c.gridy = 0;
		gridbag.setConstraints(label,c);
		add(label);
		label = new Label("View");	
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 0;
		gridbag.setConstraints(label,c);
		add(label);
		m_solutioncount = new Label("Solutions: ");
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 0;
		gridbag.setConstraints(m_solutioncount,c);
		add(m_solutioncount);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		gridbag.setConstraints(m_processwindow,c);		
		add(m_processwindow);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 1;
		gridbag.setConstraints(m_viewwindow,c);
		add(m_viewwindow);
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 1;
		gridbag.setConstraints(m_viewlist,c);
		add(m_viewlist);
		Panel temp = new Panel();
		temp.add(m_stopbutton);
		temp.add(m_continuebutton);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 2;
		gridbag.setConstraints(temp,c);
		add(temp);
		label = new Label("Copyright © 1998, Particle");
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 2;
		gridbag.setConstraints(label,c);		
		add(label);
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 2;
		gridbag.setConstraints(m_viewbutton,c);
		add(m_viewbutton);

	}

	/**
	 * allow this thread to start
	 */
	public void start(){
		if(m_queens == null){
			m_queens = new Thread(this);
			m_queens.start();
		}
	}
	
	/**
	 * check to see if the queen is attacking...
	 */
	public boolean attacks(byte[] row,int col){
		int diff = row[col] - col;
		int sum = row[col] + col;
		for(int i=0;i<col;i++)
			if(row[i] == row[col])
				return true;
			else if((row[i] - i) == diff)
				return true;
			else if((row[i] + i) == sum)
				return true;
		return false;
	}

	/**
	 * found a solutin, if we're running for the first time,
	 * then put the solution onto the list.
	 */
	public void solution(byte[] sol){
		if(!m_already_ran){
			String s = new String();
			for(int i = 0;i<sol.length;i++)
				s += sol[i];
			m_viewlist.add(s);
			m_solutioncount.setText("Solutions: "+m_viewlist.getItemCount()+"  ");
		}
	}

	/**
	 * the actual 8-queens algorithm
	 */
	public void find8Queens(byte[] row){
		int col = 0;
		row[col] = -1;
		while(m_processwindow == null);
		while(col >= 0){
			row[col]++;
			m_processwindow.setWhatToDraw(row);
			try{				
				Thread.sleep(m_sleeptime);
			}catch(InterruptedException e){}	

			while(row[col] < 8 && attacks(row,col)){
				row[col]++;
				m_processwindow.setWhatToDraw(row);
				try{				
					Thread.sleep(m_sleeptime);
				}catch(InterruptedException e){}	
			}
			if(row[col] < 8)
				if(col == 7)
					solution(row);
				else
					row[++col] = -1;
			else
				col--;
		}
	}
	
	/**
	 * runs the thread (most action is happening in the find8queens
	 * method anyway.
	 */
	public void run(){
		byte[] arr = new byte[8];
		while(true){
			for(int i = 0;i<arr.length;i++)
				arr[i] = 0;
			find8Queens(arr);
			/* suspend the thread if running the first time, and 
				completed the search */
			if(m_already_ran == false && m_queens != null)
				m_queens.suspend();
			m_already_ran = true;
			m_sleeptime = 15;
		}
	}

	/**
	 * a button has been pressed.
	 */
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand() == "Stop"){
			if(m_queens != null)
				m_queens.suspend();
		}else if(e.getActionCommand() == "Continue"){
			if(m_queens != null)
				m_queens.resume();
		}else if(e.getActionCommand() == "View"){
			String selection = m_viewlist.getSelectedItem();
			if(selection != null){
				byte[] arr = new byte[8];
				for(int i=0;i<8;i++)
					arr[i] = (byte)(Integer.parseInt(""+selection.charAt(i)));
				m_viewwindow.setWhatToDraw(arr);			
			}
		}
	}
}
