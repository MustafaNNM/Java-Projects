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
	private Boolean hata_var_m� = false;
	/**
	 * 
	 */
	public ChatRoom() {
		// System.out.println("ChatRoom olu�turuluyor");
		
		setHata_var_m�(create_async_server());
		if (getHata_var_m�() == false) {
			setHata_var_m�(start_async_server());
			if (getHata_var_m�() == false) {
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
		Boolean hata_var_m� = false;
		server = new Server();
		if (Server.getSs() != null) {
			try {
				// System.out.println("async_server = new Thread(new
				// Server());");
				async_server = new Thread(server);// Server paralel
													// ba�lat�l�yor
			} catch (Exception e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("Exception");
				System.out.println("Exception");
				e.printStackTrace();
			}
			return hata_var_m�;
		} else {
			hata_var_m� = true;
			ChatRoomApplet.GelenKutusu.append("\nServer.getSs() is null");
			System.out.println("Server.getSs() != null");
			return hata_var_m�;
		}
	}

	/**
	 * @return
	 * 
	 */
	private Boolean start_async_server() {
		Boolean hata_var_m� = false;
		if (hata_var_m� == false) {
			try {
				// System.out.println("async_server.start();");
				async_server.start();
			} catch (IllegalThreadStateException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("IllegalThreadStateException");
				System.out.println("IllegalThreadStateException");
				e.printStackTrace();
			} catch (Exception e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("Exception");
				System.out.println("Exception");
				e.printStackTrace();
			}
			return hata_var_m�;
		} else {
			ChatRoomApplet.GelenKutusu.append("Hata var!");
			return hata_var_m�;
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
	 * @return the hata_var_m�
	 */
	public Boolean getHata_var_m�() {
		return hata_var_m�;
	}

	/**
	 * @param hata_var_m� the hata_var_m� to set
	 */
	public void setHata_var_m�(Boolean hata_var_m�) {
		this.hata_var_m� = hata_var_m�;
	}

}
