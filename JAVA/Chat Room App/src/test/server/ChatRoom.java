/**
 * 
 */
package test.server;

import server.Server;

/**
 * @author MehmetAkif-PC
 *
 */
public class ChatRoom {
	private static Thread async_server;

	/**
	 * 
	 */
	public ChatRoom() {
		//System.out.println("ChatRoom oluþturuluyor");
		create_async_server();
		start_async_server();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println("Uygulama baþlatýlýyor");		
		//System.out.println("create_async_server();");
		@SuppressWarnings("unused")
		ChatRoom chatroom=new ChatRoom();
		//System.out.println("start_async_server();");
		
	}

	/**
	 * 
	 */
	private static void start_async_server() {
		try {
			//System.out.println("async_server.start();");
			async_server.start();
		} catch (IllegalThreadStateException e) {
			System.out.println("Exception");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private static void create_async_server() {
		try {
			//System.out.println("async_server = new Thread(new Server());");
			async_server = new Thread(new Server());//Server paralel baþlatýlýyor
		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
		}
		//async_server.stop();
	}

	/**
	 * @return the async
	 */
	public static Thread getAsync() {
		return async_server;
	}

	/**
	 * @param async
	 *            the async to set
	 */
	public static void setAsync(Thread async) {
		ChatRoom.async_server = async;
	}


}
