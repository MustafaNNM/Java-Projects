package server;
/**
 * 
 */

import gui.server.ChatRoomApplet;

/**
 * @author MehmetAkif-PC
 *
 */
public class ChatRoom {
	private static Server server;
	private Thread async_server;
	private Boolean hata_var_mý = false;
	/**
	 * 
	 */
	public ChatRoom() {
		// System.out.println("ChatRoom oluþturuluyor");
		
		setHata_var_mý(create_async_server());
		if (getHata_var_mý() == false) {
			setHata_var_mý(start_async_server());
			if (getHata_var_mý() == false) {
				// continue;
			} else {
				// exit
			}
		} else {
			// exit
		}
	}

	/**
	 * @return
	 * 
	 */
	private Boolean create_async_server() {
		Boolean hata_var_mý = false;
		server = new Server();
		if (Server.getSs() != null) {
			try {
				// System.out.println("async_server = new Thread(new
				// Server());");
				async_server = new Thread(server);// Server paralel
													// baþlatýlýyor
			} catch (Exception e) {
				hata_var_mý = true;
				ChatRoomApplet.GelenKutusu.append("Exception");
				System.out.println("Exception");
				e.printStackTrace();
			}
			return hata_var_mý;
		} else {
			hata_var_mý = true;
			ChatRoomApplet.GelenKutusu.append("\nServer.getSs() is null");
			System.out.println("Server.getSs() != null");
			return hata_var_mý;
		}
	}

	/**
	 * @return
	 * 
	 */
	private Boolean start_async_server() {
		Boolean hata_var_mý = false;
		if (hata_var_mý == false) {
			try {
				// System.out.println("async_server.start();");
				async_server.start();
			} catch (IllegalThreadStateException e) {
				hata_var_mý = true;
				ChatRoomApplet.GelenKutusu.append("IllegalThreadStateException");
				System.out.println("IllegalThreadStateException");
				e.printStackTrace();
			} catch (Exception e) {
				hata_var_mý = true;
				ChatRoomApplet.GelenKutusu.append("Exception");
				System.out.println("Exception");
				e.printStackTrace();
			}
			return hata_var_mý;
		} else {
			ChatRoomApplet.GelenKutusu.append("Hata var!");
			return hata_var_mý;
		}
	}

	/**
	 * @return the async
	 */
	public Thread getAsync() {
		return async_server;
	}

	/**
	 * @return the server
	 */
	public Server getServer() {
		return server;
	}

	/**
	 * @param server
	 *            the server to set
	 */
	public void setServer(Server server) {
		ChatRoom.server = server;
	}

	/**
	 * @return the async_server
	 */
	public Thread getAsync_server() {
		return async_server;
	}

	/**
	 * @param async_server
	 *            the async_server to set
	 */
	public void setAsync_server(Thread async_server) {
		this.async_server = async_server;
	}

	/**
	 * @param async
	 *            the async to set
	 */
	public void setAsync(Thread async) {
		this.async_server = async;
	}

	/**
	 * @return the hata_var_mý
	 */
	public Boolean getHata_var_mý() {
		return hata_var_mý;
	}

	/**
	 * @param hata_var_mý the hata_var_mý to set
	 */
	public void setHata_var_mý(Boolean hata_var_mý) {
		this.hata_var_mý = hata_var_mý;
	}

}
