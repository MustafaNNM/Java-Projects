import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;


public class iki_boyut extends javax.swing.JFrame{

	public static void main(String[] args) {
//		Rectangle2D g = new Rectangle2D();
//		paintComponent(g);
//		Graphics g1=null;
//		final Graphics2D g2d=(Graphics2D) g1;
//		Ellipse2D.Double circle = new Ellipse2D.Double(12, 23, 34, 45);
//		g2d.fill(circle);
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		Ellipse2D.Double circle = new Ellipse2D.Double(15, 15, 90, 90);
		Rectangle2D.Double square =
		new Rectangle2D.Double(10, 10, 100, 100);
		g2d.fill(circle);
		g2d.draw(square);
		}
}
