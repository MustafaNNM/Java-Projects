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
		Request_Handler request_handler = new Request_Handler();
		CNDServer cdnServer=new CNDServer();
		cdnServer.getServer().setHandler(request_handler);
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
