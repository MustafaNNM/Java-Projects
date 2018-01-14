package denemeyedevam;

public class CNDApp {

	public static void main(String[] args) throws Exception {
		
		HelloWorld helloWorld = new HelloWorld();
		CNDServer cdnServer=new CNDServer();
		cdnServer.getServer().setHandler(helloWorld);
		cdnServer.getServer().start();
		cdnServer.getServer().join();
	}

	public CNDApp() {
		super();
	}
}