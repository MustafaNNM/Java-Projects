/**
 * 
 */
package test;

import javax.swing.JApplet;
import javax.swing.JFrame;

import gui.server.ChatRoomApplet;

/**
 * @author MehmetAkif-PC
 *
 */
public class Bismillahirrahmanirrahim extends JApplet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        JFrame window = new JFrame("Application Name");
        ChatRoomApplet ChatRoomApplet=new ChatRoomApplet();
        window.setContentPane(ChatRoomApplet.getContentPane());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }

}
