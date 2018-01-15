/**
 * 
 */

/**
 * @author MehmetAkif-PC
 *
 */
public class OHDS {

	/**
	 * 
	 */
	public OHDS() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloWorld helloWorld = new HelloWorld();
		CNDServer cdnServer=new CNDServer();
		cdnServer.getServer().setHandler(helloWorld);
		try {
			cdnServer.getServer().start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cdnServer.getServer().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
