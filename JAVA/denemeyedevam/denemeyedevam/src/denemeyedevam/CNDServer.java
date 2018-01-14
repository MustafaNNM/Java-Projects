/**
 * 
 */
package denemeyedevam;

import org.eclipse.jetty.server.Server;

/**
 * @author ENTER-NET
 *
 */
public class CNDServer {
	private int port = 8080;
	private Server server = new Server(port);

	public CNDServer() {
		super();
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}
}
