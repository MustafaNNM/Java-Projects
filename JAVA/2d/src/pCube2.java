/*
 * pCube2.java
 * 
 * By using this software you have agreed to:
 *  NOBODY is responsible for ANYTHING undesirable this program does.
 *  (this includes any software thats derived from this code)
 *
 * http://www.theparticle.com
 * 
 * Copyright(c) 2001, Particle
 */

import java.applet.*;
import java.awt.*;
import java.util.Vector;

/**
 * pCube2 applet class
 * 
 * use it as you see fit, but please give credit when it is due.
 * 
 * 
 * Some of this code has been derived from Quake1 tools, since
 * I was too lazy to type my own, and cut+paste seemed like
 * a quick & easy way of reusing good parts of those tools.
 * 
 * There are also a few pieces of code from Michael Abrash's books.
 */
public class pCube2 extends Applet { // implements Runnable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//	private Thread m_pCube = null;
	private int m_width,m_height;
	
	// support for double buffer
	private Image m_image;
	private Graphics m_g;

	// angle, mouse state
	private double m_anglex,m_angley;
	private int m_mousex,m_mousey;	
	
	// points for the cube
	private double[][] points = {
		{15,15,15,1},{15,15,-15,1},{-15,15,-15,1},{-15,15,15,1},
		{15,-15,15,1},{15,-15,-15,1},{-15,-15,-15,1},{-15,-15,15,1}
	};
	
	// cube's faces
	private int[][] faces = {
		{0,1,2,3},{7,6,5,4},
		{4,5,1,0},{5,6,2,1},
		{6,7,3,2},{7,4,0,3}
	};
	
	// method is called when applet initializes
	public void init(){
		m_width = size().width;
		m_height = size().height;
		
		// init angle + mouse
		m_mousex = m_mousey = 0;
		m_anglex = m_angley = Math.PI/4;

		// init double buffer
		m_image = createImage(m_width,m_height);
		m_g = m_image.getGraphics();

		
		
		
		// triangulate the cube (using a very ugly approach)
		
		Vector p = new Vector();
		Vector f = new Vector();
		int i;
		for(i=0;i<points.length;i++)
			p.addElement(points[i]);
		int count = i;
		for(i=0;i<faces.length;i++){
			double[] a = new double[4];
			a[0] = (points[faces[i][0]][0] + points[faces[i][2]][0]) /5;
			a[1] = (points[faces[i][0]][1] + points[faces[i][2]][1]) /5;
			a[2] = (points[faces[i][0]][2] + points[faces[i][2]][2]) /5;
			a[3] = 1;
			p.addElement(a);
			int[][] b = {
				{count,faces[i][0],faces[i][1]},
				{count,faces[i][1],faces[i][2]},
				{count,faces[i][2],faces[i][3]},
				{count,faces[i][3],faces[i][0]}
			};
			for(int j=0;j<4;j++)
				f.addElement(b[j]);
			count++;
		}
		
		points = new double[p.size()][4];
		for(i=0;i<points.length;i++)
			points[i] = (double[])p.elementAt(i);
		faces = new int[f.size()][3];
		for(i=0;i<faces.length;i++)
			faces[i] = (int[])f.elementAt(i);	
		
	}

	
	/**
	 * compares faces by middle z
	 */
	public int comparePointsByZ(int[] a,int[] b,double[][] p){
		
		// find middle z of faces
		double ax,bx;
		int i;
		ax = 0;
		for(i=0;i<a.length;i++)
			ax+=p[a[i]][2];
		ax /= a.length;
		bx = 0;
		for(i=0;i<b.length;i++)
			bx+=p[b[i]][2];
		bx /= b.length;
		
		// compare them
		if(ax > bx)
			return 1;
		else if(ax < bx)
			return -1;
		return 0;
	}
	
	/**
	 * sort faces by their middle Z using insertion sort
	 * (could be time consuming for large number of faces)
	 */
	public void sortFacesByZ(int[][] a,double[][] p){
		int i,j;
		int[] e;
		for(i=1;i<a.length;i++){
			e = a[i];
			for(j=i-1;j>=0 && comparePointsByZ(a[j],e,p) > 0;j--)
				a[j+1] = a[j];
			a[j+1] = e;
		}
	}	
	
	// paint
	public void paint(Graphics g){
		
		// clear screen (in double buffer)
		m_g.setColor(Color.white);
		m_g.fillRect(0,0,m_width,m_height);
		
		// make our transformed points
		double[][] _points1 = new double[points.length][4];
		// make our transformed points
		double[][] _points = new double[points.length][4];
		

		// create initial matrix
		double[][] m1 = new double[4][4];
		clearMatrix(m1);
		double[][] m2 = new double[4][4];
		
		// scale cube
		scaleMatrix(m1,3,m2);
		
		// rotate it (using the angles)
		rotateMatrixX(m2,m_anglex,m1);
		rotateMatrixY(m1,m_angley,m2);
		
		// translate it away from the origin
		translateMatrix(m2,0,0,-200,m1);
		
		// trnansform all points in the cube using the matrix
		for(int i=0;i<points.length;i++){
			transformVertex(m1,points[i],_points[i]);
		}

		// prepare perspective transform matrix
		projectPerspectiveMatrix(m_width,-1,m2);

		// Z-sort faces
		sortFacesByZ(faces,_points);

		// for all faces
		for(int i=0;i<faces.length;i++){
			int[] face = faces[i];

			// get the plane equation of the transformed face
			double[] plane = new double[4];
			planeFromPoints(plane,_points[face[0]],_points[face[1]],_points[face[2]]);
			double d = plane[3];

			// if the face is facing us ;-)
			if(d > 0){
				
				// prepare params for java's fill poly
				int[] x = new int[face.length];
				int[] y = new int[face.length];
				
				// apply perspective transform, and move to center of viewing area
				for(int j=0;j<face.length;j++){
					
					transformVertex(m2,_points[face[j]],_points1[face[j]]);
					_points1[face[j]][0] /= _points1[face[j]][3];
					_points1[face[j]][1] /= _points1[face[j]][3];
					_points1[face[j]][2] /= _points1[face[j]][3];
					
					x[j] = (int)_points1[face[j]][0];
					x[j] += m_width/2;
					y[j] = (int)_points1[face[j]][1];
					y[j] += m_height/2;					
				}
				
				// create face color (using it's angle to view plane)
				int color = (int)(90 + d);
				if(color > 0xFF)
					color = 0xFF;
				
				// set color for fill
				m_g.setColor(new Color(color,
									 color,
									 color));
				// fill poly
				m_g.fillPolygon(x,y,face.length);

				// draw borders, and vertex numbers.
				m_g.setColor(Color.black);
				m_g.drawPolygon(x,y,face.length);
				for(int j=0;j<face.length;j++){
					m_g.drawString(""+face[j],x[j],y[j]);
				}
			}
			
		}
		// blit double buffer into primary buffer
		g.drawImage(m_image,0,0,null);
	}

	// is called asynchronously when redraw() is called
	public void update(Graphics g){
		paint(g);
	}

	/*
	public void start(){
		if (m_pCube == null){
			m_pCube = new Thread(this);
			m_pCube.start();
		}
	}

	public void run(){
		while (true){
			try{
				repaint();
				Thread.sleep(50);
			}catch(InterruptedException e){
				System.out.println(e);
			}
		}
	}
	*/
	
	// create perspective matrix
	void projectPerspectiveMatrix(double zprp,double zvp,double[][] d){
		clearMatrix(d);
		double d1 = zprp - zvp;
		d[2][2] = -zvp/d1;	d[2][3] = zvp*(zprp/d1);
		d[3][2] = -1/d1;	d[3][3] = zvp/d1;
	}
	
	/*
	 * 4x4 matrix * 4x1 vertex = 4x1 vertex 
	 */
	void transformVertex(double[][] m,double[] s,double[] d){
		int i,j;
		for(i=0;i<4;i++){
			d[i] = 0;
			for(j=0;j<4;j++)
				d[i] += m[i][j] * s[j];
		}
	}
	
	/*
	 * 4x4 matrix * 4x4 matrix = 4x4 matrix
	 */
	void crossProductMatrix(double[][] s1,double[][] s2,double[][] d){
		int i,j,k;
		for(i=0;i<4;i++){
			for(j=0;j<4;j++){
				d[i][j] = 0;
				for(k=0;k<4;k++)
					d[i][j] += s1[i][k] * s2[k][j];
			}
		}
	}

	void scaleMatrix(double[][] s1,double s,double[][] d){
		double[][] s2 = new double[4][4];
		int i,j;
		for(i=0;i<4;i++)
			for(j=0;j<4;j++)
				s2[i][j] = (i == j) ? s:0;
		s2[3][3] = 1;
		crossProductMatrix(s2,s1,d);
	}

	void translateMatrix(double[][] s1,double x,double y,double z,double[][] d){
		double[][] s2 = new double[4][4];
		clearMatrix(s2);
		s2[0][3] = x;
		s2[1][3] = y;
		s2[2][3] = z;
		crossProductMatrix(s2,s1,d);
	}
	
	void rotateMatrixX(double[][] s1,double a,double[][] d){
		double[][] s2 = new double[4][4];
		clearMatrix(s2);
		double sin = Math.sin(a);
		double cos = Math.cos(a);
		s2[1][1] = cos; 	s2[1][2] = -sin;
		s2[2][1] = sin;		s2[2][2] = cos;
		crossProductMatrix(s2,s1,d);
	}

	void rotateMatrixY(double[][] s1,double a,double[][] d){
		double[][] s2 = new double[4][4];
		clearMatrix(s2);
		double sin = Math.sin(a);
		double cos = Math.cos(a);
		s2[0][0] = cos; 	s2[0][2] = sin;
		s2[2][0] = -sin;	s2[2][2] = cos;
		crossProductMatrix(s2,s1,d);
	}
	
	
	void clearMatrix(double[][] d){
		int i,j;
		for(i=0;i<4;i++)
			for(j=0;j<4;j++)
				d[i][j] = (i == j) ? 1:0;
	}
	
	// print matrix for debug purposes
	void printMatrix(double[][] d){
		int i,j;
		for(i=0;i<4;i++){
			for(j=0;j<4;j++)
				System.out.print(d[i][j]+" ");
			System.out.println("");
		}
		System.out.println("");
	}
	
	void vectorSubtract (double[] va, double[] vb, double[] out){
		out[0] = va[0]-vb[0];
		out[1] = va[1]-vb[1];
		out[2] = va[2]-vb[2];
	}
	
	// cross product of two vectors
	void crossProduct(double[] v1, double[] v2, double[] cross ) {
		cross[0] = v1[1]*v2[2] - v1[2]*v2[1];
		cross[1] = v1[2]*v2[0] - v1[0]*v2[2];
		cross[2] = v1[0]*v2[1] - v1[1]*v2[0];
	}

	double vectorNormalize(double[] in, double[] out ) {
		double	length, ilength;
		length = Math.sqrt(in[0]*in[0] + in[1]*in[1] + in[2]*in[2]);
		if (length == 0){
			return 0;
		}
		ilength = 1.0/length;
		out[0] = in[0]*ilength;
		out[1] = in[1]*ilength;
		out[2] = in[2]*ilength;
		return length;
	}	

	double dotProduct (double[] v1, double[] v2){
		return v1[0]*v2[0] + v1[1]*v2[1] + v1[2]*v2[2];
	}
		
	// gets plane equation from three points on plane
	boolean planeFromPoints(double[] plane, double[] a, double[] b,double[] c ) {
		double[] d1 = new double[4];
		double[] d2 = new double[4];
		vectorSubtract( b, a, d1 );
		vectorSubtract( c, a, d2 );
		crossProduct( d2, d1, plane );
		if ( vectorNormalize( plane, plane ) == 0 ) {
			return false;
		}
		plane[3] = dotProduct( a, plane );
		return true;
	}
	
	// mouse event handler	
	public boolean mouseDrag(Event evt, int x, int y){
		if((m_mousey - y) < 0)
			m_anglex += Math.PI/45;
		if((m_mousey - y) > 0)
			m_anglex -= Math.PI/45;

		if((m_mousex - x) < 0)
			m_angley -= Math.PI/45;
		if((m_mousex - x) > 0)
			m_angley += Math.PI/45;
		m_mousex = x;
		m_mousey = y;

		// update screen with new angles
		repaint();
		
		return true;
	}
	
	
}
