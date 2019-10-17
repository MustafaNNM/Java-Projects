/**
 * 
 */
package application.web;

import org.eclipse.jetty.server.Server;

/**
 * @author ENTER-NET
 *
 */
public class CDNServer {
	public int port = 8080;
	public Server server;

	public CDNServer() {
		super();
		try {// EofException//IOException
			server=new Server(port);
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
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	/**
	 * @param port
	 * @param server
	 */
	public CDNServer(int port, Server server) {
		this.port = port;
		this.server = server;
	}
}
