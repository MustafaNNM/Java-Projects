/**
 * 
 */
package application.web;

import java.io.IOException;
import java.net.BindException;

import org.eclipse.jetty.io.EofException;

/**
 * @author MehmetAkif-PC
 *
 */
public class WebSite implements Runnable {
	static Pages pages = null;
	static CDNServer cdnServer;
	@Override
	public void run() {
		// ******
		try {
			pages = new Pages();
		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		}
		try {
			cdnServer = new CDNServer();
		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		}
		try {
			cdnServer.getServer().setHandler(pages);
		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		}
		try {// EofException//IOException
			cdnServer.getServer().start();
		} catch (BindException e) {
			// java.net.BindException
			System.out.println("BindException");
			e.printStackTrace();
			System.exit(1);
			return;
		} catch (EofException e) {
			System.out.println("input.position(start); EofException");
			e.printStackTrace();
			System.exit(1);
			return;
		} catch (IOException e) {
			System.out.println("input.position(start); IOException");
			e.printStackTrace();
			System.exit(1);
			return;
		} catch (SecurityException e) {
			System.out.println("input.position(start); IOException");
			e.printStackTrace();
			System.exit(1);
			return;
		} catch (Exception e) {
			System.out.println("input.position(start); Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		}
		try {
			cdnServer.getServer().join();//server tamamen açýlana kadar tüm iþlemleri bekletiyor.
		} catch (InterruptedException e) {
			System.out.println("InterruptedException");
			e.printStackTrace();
			System.exit(1);
			return;
		} catch (SecurityException e) {
			System.out.println("input.position(start); IOException");
			e.printStackTrace();
			System.exit(1);
			return;
		} catch (Exception e) {
			System.out.println("input.position(start); Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		}
		// ******
		//return;
	}
	//return;
}
