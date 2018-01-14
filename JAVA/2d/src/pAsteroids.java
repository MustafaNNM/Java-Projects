/*
 * pAsteroids.java
 *
 * Permission to use in any way you please, provided credit is
 * given to the author. If you're going to port it, use it on
 * your website, or anything you consider important, could 
 * you please send an e-mail (to bsptree at NO SPAM geocities dot com) (just 
 * so that I can put a link to your page ;-)
 *
 * Disclaimer: I take no responsibility for anything that you 
 * don't like about the applet. So, remember, if it's bad, 
 * don't blame me, if it's good, thank me ;-)
 *
 * Copyright(c) 1999-2001, Particle
 */

import java.applet.*;
import java.awt.*;
import java.util.*;

/*
 * an asteroids game;
 *
 * Some of you may be wondering why I crunched it all into
 * one file, or better yet, into one class!... well, I like
 * the OO approach as well, and would love to have diff 
 * objects for ship, and rocks, etc... but this is suppose
 * to be a "fast" applet, and having several objects is just
 * not going to get me the loading speed I'm after. (I want
 * it to load very quickly!) that's why I'm not using any 
 * sounds for weapons or collisions, etc... just trying to 
 * keep the size small (hey, some of us still have a 28.8 
 * modem!)
 *
 * Anyway, with the total *.class site of about 11k, I'd
 * say I made the right choice.
 */
public class pAsteroids extends Applet implements Runnable{

	/**
	 * the main running thread
	 */
	private Thread		m_pAsteroids = null;

	/**
	 * dimentions of the game canvas
	 */
	private int			m_width;
	private int			m_height;

	/**
	 * draw the stars?
	 */
	private boolean		m_drawstars;

	/**
	 * support for double buffering
	 */
	private Graphics	m_Graphics;
	private Image		m_Image;

	/**
	 * allow customization of background & foreground
	 */
	private Color		m_fgcolor;
	private Color		m_bgcolor;

	/**
	 * parameters for game
	 */
	public double param_ship_max_forward_speed = 10;	/* forward speed */
	public double param_ship_max_back_speed = 5;	/* back speed */
	public double param_ship_acceleration_speed = .5;	/* acceleration constant*/
	public double param_ship_turn_speed = Math.PI/0x10;	/* angle in rad */
	public double param_plasma_speed =  param_ship_max_forward_speed+
		param_ship_max_back_speed;	/* the speed of plasma */
	public double param_plasma_time=500;		/* how long plasma lasts */
	public double param_start_score = 5000;	/* starting score for game */
	public double param_shotspersec = 5;	/* allowed shots per second */
	public double param_score_for_hit = 1000;	/* penalty */
	public double param_score_for_shoot = 1;	/* penalty for shooting */
	public double param_score_maxkill = 100;	/* destroying the smallest rock */
	public double param_max_asteroids = 20;
	public double param_min_asteroids = 10;

	/**
	 * selected keys; these will have the states of the 
	 * keys. true if pressed, false otherwise.
	 */
	private boolean		key_up,key_down,key_left,key_right,key_space;

	/**
	 * score; make the game a bit interesting.
	 * (large asteroid: 50 points, small asteroid 100 points, 
	 *	 your death, -1000 points, each shot, -1 point, you start
	 *   0 score, but it grows consantly <but very slowly>)
	 */
	private double		m_score;

	/**
	 * lock the speed of shooting.
	 */
	private double		m_num_shots_per_sec;
	private double		m_lastshottime;

	/**
	 * the ship
	 */
	public Polygon		m_ship;			/* original model */
	public Polygon		m_ship_t;		/* transformed */
	public double		m_ship_angle;	/* angle it's facing */
	public double		m_ship_x,m_ship_y;	/* the x & y location */
	public double		m_ship_speed;	/* the speed of the ship */

	/**
	 * ship's speed variables
	 */
	public double		m_ship_max_forward_speed;	/* forward speed */
	public double		m_ship_max_back_speed;	/* back speed */
	public double		m_ship_acceleration_speed;	/* acceleration constant*/
	public double		m_ship_turn_speed;	/* angle inc in rad */

	/**
	 * plasma variables's... (speed, and existance time)
	 */
	public double		m_plasma_speed;	/* the speed of plasma */
	public double		m_plasma_wait;	/* how long plasma lasts */

	/**
	 * plasma
	 */
	public Vector		m_plasma;		/* plasma points */
	public Vector		m_plasma_dx;	/* plasma transforms */
	public Vector		m_plasma_time;	/* plasma time (remaining active time) */

	/**
	 * asteroids data
	 */
	public int		m_asteroids_max;
	public int		m_asteroids_min;
	public Vector	m_asteroids;		/* original models */
	public Vector	m_asteroids_t;		/* transformed */
	public Vector	m_asteroids_coords;	/* asteroids points */
	public Vector	m_asteroids_dx;		/* the dx translation vector */
	public Vector	m_asteroids_sizespeed;	/* a Point object representing size and speed */
	public Vector	m_asteroids_angle;	/* asteroids angle */

	/**
	 * starts in the background
	 */
	public Vector		m_background;	/* stars */
	public Color		m_stars_color;	/* color of the stars */

	/**
	 * general purpose removelist
	 */
	private Vector removelist;


	/**
	 * handle ship rendering
	 */
	void handleShipRendering(){
		double sin = Math.sin(m_ship_angle);
		double cos = Math.cos(m_ship_angle);
		m_ship_t = new Polygon();
		for(int i = 0;i<m_ship.npoints;i++)
			m_ship_t.addPoint(
			(int)Math.round(m_ship.xpoints[i]*cos+
				m_ship.ypoints[i]*sin)+(int)Math.round(m_ship_x),
			(int)Math.round(m_ship.ypoints[i]*cos-
				m_ship.xpoints[i]*sin)+(int)Math.round(m_ship_y));
	}

	/**
	 * draw the ship
	 */
	void drawShip(Graphics g){
		if(m_drawstars){
			g.setColor(m_bgcolor);
			g.fillPolygon(m_ship_t);
			g.setColor(m_fgcolor);
		}
		g.drawPolygon(m_ship_t);
	}

	/**
	 * draw all of plasma
	 */
	void drawPlasma(Graphics g){
		Enumeration enum;
		enum = m_plasma.elements();
		while(enum.hasMoreElements()){
			Point p = (Point)enum.nextElement();
			g.fillRect(p.x-1,p.y-1,2,2);
		}
	}


	/**
	 * draw all asteroids (they should already be rendered
	 */
	void drawAsteroids(Graphics g){
		Enumeration enum;
		enum = m_asteroids_t.elements();
		while(enum.hasMoreElements()){
			Polygon p = (Polygon)enum.nextElement();
			if(m_drawstars){
				g.setColor(m_bgcolor);
				g.fillPolygon(p);
				g.setColor(m_fgcolor);
			}
			g.drawPolygon(p);
		}
	}

	/**
	 * make the ship shoot
	 */
	void shipShoot(){
		double currentshot = System.currentTimeMillis();
		double timediff = currentshot - m_lastshottime;
		if(timediff < 1000/m_num_shots_per_sec)
			return;
		m_lastshottime = currentshot;

			/* make it a bit more challenging */
		/* too many people are becoming confused because of this, 
			so, I think it's best to leave that feature out. */
		/* if(m_score <= 0)
			return;	 */
		
		m_score--;

		Point p = new Point((int)m_ship_x,(int)m_ship_y);
		p.translate((int)(Math.cos(m_ship_angle)*m_plasma_speed),
			(int)(-Math.sin(m_ship_angle)*m_plasma_speed));
		m_plasma.addElement(p);
		Point dx = new Point((int)(Math.cos(m_ship_angle)*m_plasma_speed),
			(int)(-Math.sin(m_ship_angle)*m_plasma_speed));
		m_plasma_dx.addElement(dx);
		m_plasma_time.addElement(new Point((int)m_plasma_wait,0));
	}

	/**
	 * draw things like he score
	 */
	void drawStatistics(Graphics g){
		m_score = (double)Math.round(m_score);
		g.drawString("["+m_score+"]",20,20);
	}

	/**
	 * draw the entire scene (calls all drawing functions)
	 */
	void drawScene(Graphics g){
		drawStatistics(g);
		drawPlasma(g);
		drawAsteroids(g);
		drawShip(g);
	}

	/**
	 * creates one asteroid with the specified size, and x,y
	 */
	void createAsteroid(int _size,int _x,int _y){
		
		if(m_asteroids.size() >= m_asteroids_max)
			return;
		
		Point sizespeed = new Point(_size,(int)(Math.random() * m_ship_max_back_speed));
		double[] angle = new double[2];
		angle[0] = 0;
		angle[1] = Math.random() * Math.PI/0x10;
		Point coords = new Point(_x,_y);
		Point dx = new Point(0,0);
		while(dx.x == 0 || dx.y == 0){
			dx.x = (int)Math.round((Math.random()-.5) * m_ship_max_back_speed);
			dx.y = (int)Math.round((Math.random()-.5) * m_ship_max_back_speed);
		}
		Polygon asteroid = new Polygon();
		double PI2 = Math.PI * 2;
		double PIINC = Math.PI/(6*_size);

		double rad = m_ship_max_forward_speed*sizespeed.x;
		for(double ang=0;ang < PI2;ang += PIINC){
			asteroid.addPoint((int)(rad * Math.cos(ang)),(int)(rad * Math.sin(ang)));
			rad = m_ship_max_forward_speed*sizespeed.x + 
				((Math.random()-.5) * m_ship_max_forward_speed);
		}
		rad = m_ship_max_forward_speed*sizespeed.x;
		asteroid.addPoint((int)rad,0);

		m_asteroids.addElement(asteroid);
		m_asteroids_coords.addElement(coords);
		m_asteroids_dx.addElement(dx);	
		m_asteroids_sizespeed.addElement(sizespeed);
		m_asteroids_angle.addElement(angle);
	}

	/**
	 * function to make sure that there are at least
	 * m_asteroids_min asteroids floating around, if not, 
	 * create a new one.
	 */
	void rebuldAsteroids(){
		int num = m_asteroids.size();
			/* find out how many we have to add */
		num = (int)(m_asteroids_max - num);
		if(num <= 0)
			return;		/* dont' add anything this time */
		for(int i=0;i<num;i++)
			createAsteroid((int)(Math.random() * m_ship_max_forward_speed),
			(int)Math.round(m_width + Math.random()*m_width),
				(int)Math.round(m_height + Math.random()*m_height));
	}

	/**
	 * function to handle the rendering
	 */
	void handleAsteroidRendering(){

		Enumeration enum_asteroids,enum_angle,enum_coords;

		enum_asteroids = m_asteroids.elements();
		enum_angle = m_asteroids_angle.elements();
		enum_coords = m_asteroids_coords.elements();

		m_asteroids_t.removeAllElements();

		while(enum_asteroids.hasMoreElements()){
			Polygon asteroid = (Polygon)enum_asteroids.nextElement();
			double[] angle = (double[])enum_angle.nextElement();
			Point p = (Point)enum_coords.nextElement();

			Polygon asteroid_t = new Polygon();

			double sin = Math.sin(angle[0]);
			double cos = Math.cos(angle[0]);

			for(int i = 0;i<asteroid.npoints;i++)
				asteroid_t.addPoint(
				(int)Math.round(asteroid.xpoints[i]*cos+
					asteroid.ypoints[i]*sin)+(int)Math.round(p.x),
				(int)Math.round(asteroid.ypoints[i]*cos-
					asteroid.xpoints[i]*sin)+(int)Math.round(p.y));
			m_asteroids_t.addElement(asteroid_t);
		}
	}

	/**
	 * function to handle collision detection and removal
	 * of detroyed asteroids. also checks if current number
	 * of polygons below the min, and calls rebuldAsteroids()
	 * if it is.
	 */
	void handleAsteroidDetection(){
		Enumeration enum_ast = m_asteroids_t.elements();
		removelist.removeAllElements();
		
		while(enum_ast.hasMoreElements()){
			Enumeration enum_pl = m_plasma.elements();
			Polygon poly = (Polygon)enum_ast.nextElement();
			boolean brokeout = false;
				/* test detection against plasma */
			while(enum_pl.hasMoreElements()){
				Point p = (Point)enum_pl.nextElement();
				if(poly.inside(p.x,p.y)){
					removelist.addElement(poly);
					int index = m_plasma.indexOf(p);
					m_plasma.removeElementAt(index);
					m_plasma_dx.removeElementAt(index);
					m_plasma_time.removeElementAt(index);
					
					index = m_asteroids_t.indexOf(poly);
					Point sizespeed = (Point)m_asteroids_sizespeed.elementAt(index);
					m_score += param_score_maxkill / sizespeed.x;

					brokeout = true;
					break;
				}
			}
			if(m_ship_t != null && !brokeout){
					/* test detection against the ship */
				for(int i = 0;i<m_ship_t.npoints;i++)
					if(poly.inside(m_ship_t.xpoints[i],m_ship_t.ypoints[i])){
						removelist.addElement(poly);
						m_score -= param_score_for_hit;
						brokeout = true;
						break;
					}
			}

			if(!brokeout){
				int index = m_asteroids_t.indexOf(poly);
				Point point = (Point)m_asteroids_coords.elementAt(index);
				if(point.x < 2 || point.x > m_width-2)
					removelist.addElement(poly);
				else if(point.y < 2 || point.y > m_height-2)
					removelist.addElement(poly);
			}

		}
		Enumeration enum = removelist.elements();
		while(enum.hasMoreElements()){
			int index = m_asteroids_t.indexOf((Polygon)enum.nextElement());
				/* account score */
			Point sizespeed = (Point)m_asteroids_sizespeed.elementAt(index);
			
			if(sizespeed.x > 1){
				int number = (int)(Math.random()*5);
				if(number != 0){
					Point coor = (Point)m_asteroids_coords.elementAt(index);
					for(int i=0;i<number;i++)
						createAsteroid(sizespeed.x-1,coor.x,coor.y);
				}
			}
			m_asteroids.removeElementAt(index);
			m_asteroids_t.removeElementAt(index);
			m_asteroids_dx.removeElementAt(index);
			m_asteroids_coords.removeElementAt(index);
			m_asteroids_sizespeed.removeElementAt(index);
			m_asteroids_angle.removeElementAt(index);
		}
		if(m_asteroids.size() < m_asteroids_min)
			rebuldAsteroids();
		removelist.removeAllElements();
	}

	/**
	 * plasma motion handler
	 */
	void handlePlasmaMotion(){
		Enumeration enum_p,enum_dx,enum_time;
		enum_p = m_plasma.elements();
		enum_dx = m_plasma_dx.elements();
		enum_time = m_plasma_time.elements();

		while(enum_p.hasMoreElements()){
			Point p = (Point)enum_p.nextElement();
			Point dx = (Point)enum_dx.nextElement();
			Point time = (Point)enum_time.nextElement();
			p.translate(dx.x,dx.y);		
			time.x--;
			if(time.x <= 0){
				m_plasma.removeElement(p);
				m_plasma_dx.removeElement(dx);
				m_plasma_time.removeElement(time);
			}
			if(p.x > m_width)
				p.x = 0;
			if(p.x < 0)
				p.x = m_width;
			if(p.y > m_height)
				p.y = 0;
			if(p.y < 0)
				p.y = m_height;
		}
	}

	/**
	 * handle asteroid motion
	 */
	void handleAsteroidMotion(){
		Enumeration enum_p,enum_dx,enum_angle;

		enum_p = m_asteroids_coords.elements();
		enum_dx = m_asteroids_dx.elements();
		enum_angle = m_asteroids_angle.elements();

		while(enum_p.hasMoreElements()){
			Point p = (Point)enum_p.nextElement();
			Point dx = (Point)enum_dx.nextElement();
			double[] angle = (double[])enum_angle.nextElement();

			p.translate(dx.x,dx.y);
			angle[0] += angle[1];
			if(angle[0] >= Math.PI*2)
				angle[0] =- Math.PI*2;
			if(p.x > m_width)
				p.x = 0;
			if(p.x < 0)
				p.x = m_width;
			if(p.y > m_height)
				p.y = 0;
			if(p.y < 0)
				p.y = m_height;
		}
	}

	/**
	 * ship motion handler
	 */
	void handleShipMotion(){
		double sin = -Math.sin(m_ship_angle);
		double cos = Math.cos(m_ship_angle);
			/* move the x */
		m_ship_x += cos * m_ship_speed;
			/* make the ship wrap around */		
		if(m_ship_x > m_width)
			m_ship_x = 0;
		if(m_ship_x < 0)
			m_ship_x = m_width;
			/* move the y */
		m_ship_y += sin * m_ship_speed;
			/* make the y wrap around */
		if(m_ship_y > m_height)
			m_ship_y = 0;
		if(m_ship_y < 0)
			m_ship_y = m_height;
		/* there is no friction in space */
	}

	/**
	 * key handler. uses the global boolean vals
	 */
	void handleKeys(){
		if(key_up){
			if(m_ship_speed < m_ship_max_forward_speed)
				m_ship_speed += m_ship_acceleration_speed;
		}
		if(key_down){
			if(m_ship_speed > -m_ship_max_back_speed)
				m_ship_speed -= m_ship_acceleration_speed;
		}
		if(key_left){
			m_ship_angle += m_ship_turn_speed;
			if(m_ship_angle > Math.PI*2)
				m_ship_angle -= Math.PI*2;
		}
		if(key_right){
			m_ship_angle -= m_ship_turn_speed;
			if(m_ship_angle < 0)
				m_ship_angle += Math.PI*2;
		}
		if(key_space)	/* provide rapid fire ;-) */
			shipShoot();
	}

	/**
	 * build the ship
	 */
	void buildShip(){
		m_ship = new Polygon();
		m_ship.addPoint(10,0);
		m_ship.addPoint(-5,5);
		m_ship.addPoint(-5,-5);
		m_ship.addPoint(10,0);		/* close the loop */
		m_ship_angle = 0;
		m_ship_x = m_width/2;
		m_ship_y = m_height/2;
			/* current speed */
		m_ship_speed = 0;
			/* init ship speed variables */
		m_ship_max_forward_speed = param_ship_max_forward_speed;
		m_ship_max_back_speed = param_ship_max_back_speed;
		m_ship_acceleration_speed =param_ship_acceleration_speed;
		m_ship_turn_speed = param_ship_turn_speed;
		m_plasma_speed = param_plasma_speed;
		m_plasma_wait = ((m_width + m_height) / m_plasma_speed)/2;
	}

	/**
	 * init method
	 */
	public void init(){
		String		param,fgcolors,bgcolors;
		param = getParameter("fgcolor");
		if (param != null)
			fgcolors = param;
		else
			fgcolors = "FFFFFF";

		param = getParameter("bgcolor");
		if (param != null)
			bgcolors = param;
		else
			bgcolors = "000000";

		param = getParameter("ship_max_fspeed");
		if(param != null)
			param_ship_max_forward_speed = (double)(Integer.parseInt(param,10));
		
		param = getParameter("ship_max_bspeed");
		if(param != null)
			param_ship_max_back_speed = (double)(Integer.parseInt(param,10));

		param = getParameter("ship_accel_speed");
		if(param != null)
			param_ship_acceleration_speed = (double)(Integer.parseInt(param,10));
		
		param = getParameter("ship_turn_speed");
		if(param != null)
			param_ship_turn_speed = (double)(Integer.parseInt(param,10));

		param = getParameter("plasma_speed");
		if(param != null)
			param_plasma_speed = (double)(Integer.parseInt(param,10));

		param = getParameter("plasma_time");
		if(param != null)
			param_plasma_time = (double)(Integer.parseInt(param,10));

		param = getParameter("start_score");
		if(param != null)
			param_start_score = (double)(Integer.parseInt(param,10));

		param = getParameter("shots_per_sec");
		if(param != null)
			param_shotspersec = (double)(Integer.parseInt(param,10));

		param = getParameter("hit_penalty");
		if(param != null)
			param_score_for_hit = (double)(Integer.parseInt(param,10));

		param = getParameter("scores_per_shot");
		if(param != null)
			param_score_for_shoot = (double)(Integer.parseInt(param,10));

		param = getParameter("max_score_for_kill");
		if(param != null)
			param_score_maxkill = (double)(Integer.parseInt(param,10));

		param = getParameter("max_asteroids");
		if(param != null)
			param_max_asteroids = (double)(Integer.parseInt(param,10));

		param = getParameter("min_asteroids");
		if(param != null)
			param_min_asteroids = (double)(Integer.parseInt(param,10));

		/*
		param = getParameter("drawstars");
		if(param != null){
			if(param.equals("yes"))
				m_drawstars = true;
			else if(param.equals("no"))
				m_drawstars = false;
		}else
		*/
		m_drawstars = true;


		m_fgcolor = new Color(Integer.parseInt(fgcolors,0x10));
		m_bgcolor = new Color(Integer.parseInt(bgcolors,0x10));
		
		setForeground(m_fgcolor);
		setBackground(m_bgcolor);

		m_width = size().width;
		m_height = size().height;

		m_Image = createImage(m_width,m_height);
		m_Graphics = m_Image.getGraphics();

		key_up = key_down = key_left = key_right = key_space = false;
		
		buildShip();

			/* limit the speed of shooting (else the game is too easy) */
		m_num_shots_per_sec = param_shotspersec;
		m_lastshottime = System.currentTimeMillis();

			/* price of a new ship */
		m_score = param_start_score;

		m_plasma = new Vector();
		m_plasma_dx = new Vector();
		m_plasma_time = new Vector();

			/* init star-filled background */
		m_background = new Vector();
		int i,j = (int)(Math.random()*((m_width*.02)*(m_height*.02)));
		for(i=0;i<j;i++){
			Point p = new Point((int)(Math.random() * m_width),
					(int)(Math.random() * m_height));
			m_background.addElement(p);
		}
		m_stars_color = new Color(0xDDDDDD);

		removelist = new Vector();
			/* specify the number of asteroids */
		m_asteroids_max = (int)param_max_asteroids;
		m_asteroids_min = (int)param_min_asteroids;
			/* create data storage for asteroids */
		m_asteroids = new Vector();
		m_asteroids_t = new Vector();
		m_asteroids_coords = new Vector();
		m_asteroids_dx = new Vector();
		m_asteroids_sizespeed = new Vector();
		m_asteroids_angle = new Vector();
			/* make sure that there are asteroids */
		rebuldAsteroids();
	}

	/**
	 * the paint method.
	 */
	public void paint(Graphics g){
		m_Graphics.setColor(m_bgcolor);
		m_Graphics.fillRect(0,0,m_width,m_height);
		
		if(m_drawstars){
			m_Graphics.setColor(m_stars_color);
			Enumeration enum = m_background.elements();
			while(enum.hasMoreElements()){
				Point p = (Point)enum.nextElement();
				m_Graphics.fillRect(p.x,p.y,1,1);
			}
		}

		m_Graphics.setColor(m_fgcolor);
		drawScene(m_Graphics);
		g.drawImage(m_Image,0,0,null);
	}

	/**
	 * overrides the default update() method
	 */
	public void update(Graphics g){
		paint(g);
	}

	/**
	 * helps start this thread
	 */
	public void start(){
		if (m_pAsteroids == null){
			m_pAsteroids = new Thread(this);
			m_pAsteroids.start();
		}
	}

	/**
	 * the run method
	 */
	public void run(){
		double scoreinc = 0;
		for(;;){
			try{
				scoreinc += .1;	/* let the score slowly grow (survivial bonus ;-) */
				if(scoreinc >= 1){
					m_score++;
					scoreinc = 0;
				}
				m_score = (double)Math.round(m_score);
				handleKeys();
				handleShipMotion();
				handleShipRendering();
				handlePlasmaMotion();
				handleAsteroidMotion();
				handleAsteroidRendering();
				handleAsteroidDetection();
				repaint();
				if(m_asteroids.size() < m_asteroids_min){
					rebuldAsteroids();
				}
				Thread.sleep(50);
			}catch (InterruptedException e){
				System.err.println(e);
			}
		}
	}
	
    public boolean isDoubleBuffered() {
        return true;
    }

	public boolean handleEvent(Event evt) {
	switch(evt.id){
	  case Event.KEY_PRESS:
	  case Event.KEY_ACTION:
		if(evt.key == Event.LEFT || evt.key == 106) /* J key */
			key_left = true;
		else if(evt.key == Event.RIGHT || evt.key == 108) /* L key */
			key_right = true;
		else if(evt.key == Event.UP || evt.key == 105) /* I key */
			key_up = true;
		else if(evt.key == Event.DOWN || evt.key == 107) /* K key */
			key_down = true;
		else if(evt.key == 32){
			if(!key_space){ 
				key_space = true;
				shipShoot();
			}
		}else if(evt.key == Event.F1){
				m_drawstars = true;
		}else if(evt.key == Event.F2){
			m_drawstars = false;
		}
		return true;
	  case Event.KEY_RELEASE:
	  case Event.KEY_ACTION_RELEASE:
		if(evt.key == Event.LEFT || evt.key == 106) /* J key */
			key_left = false;
		else if(evt.key == Event.RIGHT || evt.key == 108) /* L key */
			key_right = false;
		else if(evt.key == Event.UP || evt.key == 105) /* I key */
			key_up = false;
		else if(evt.key == Event.DOWN || evt.key == 107) /* K key */
			key_down = false;
		  else if(evt.key == 32)
			key_space = false;
		return true;
	  case Event.ACTION_EVENT:
	    return action(evt, evt.arg);
	  case Event.GOT_FOCUS:
	    return gotFocus(evt, evt.arg);
	  case Event.LOST_FOCUS:
	    return lostFocus(evt, evt.arg);
	
		/* dont' need mouse events to clutter up the system */
		/* 
	  case Event.MOUSE_ENTER:
	  case Event.MOUSE_EXIT:
	  case Event.MOUSE_MOVE:
	  case Event.MOUSE_DOWN:
	  case Event.MOUSE_DRAG:
	  case Event.MOUSE_UP:
		break;
		*/
	}
        return false;
    }

}
