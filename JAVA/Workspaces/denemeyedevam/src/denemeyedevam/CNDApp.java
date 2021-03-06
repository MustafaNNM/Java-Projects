package denemeyedevam;

import org.eclipse.jetty.server.Server;

public class CNDApp {
	private static HelloWorld helloWorld = new HelloWorld();
	private int port = 8080;
	private Server server = new Server(port);
	public static void main(String[] args) throws Exception {
		CNDApp cdnApp=new CNDApp();
		cdnApp.server.setHandler(helloWorld);
		cdnApp.server.start();
		cdnApp.server.join();
	}

	public CNDApp() {
		super();
	}

	/**
	 * @return the helloWorld
	 */
	public static HelloWorld getHelloWorld() {
		return helloWorld;
	}

	/**
	 * @param helloWorld the helloWorld to set
	 */
	public void setHelloWorld(HelloWorld helloWorld) {
		CNDApp.helloWorld = helloWorld;
	}

}