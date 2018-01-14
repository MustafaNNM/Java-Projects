import java.io.IOException;

/**
 * 
 */

/**
 * @author MehmetAkif-PC
 *
 */
public class App {

	private static NetworkService net;

	/**
	 * 
	 */
	public App() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Autostarting App");
		try {
			setNet(new NetworkService(8080,50));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		(new Thread(net)).start();
		
		System.out.println("Paralel bir sekilde calisiyor yeni bir client baslat");

	}

	/**
	 * @return the net
	 */
	public static NetworkService getNet() {
		return net;
	}

	/**
	 * @param net the net to set
	 */
	public static void setNet(NetworkService net) {
		App.net = net;
	}

}
