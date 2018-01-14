package client;

import java.nio.channels.IllegalBlockingModeException;

import gui.client.ChatRoomMemberApplet;

public class ChatRoomMember {
	private static Client client;
	private static Thread async_client;

	public ChatRoomMember() {
		// System.out.println("ChatRoomMember oluþturuluyor.");
		// System.out.println("create_async_client();");
		create_client();
		create_client_thread();
		// System.out.println("start_async_client();");
		start_async_client_thread();
		// System.out.println("async_client.started");
	}

	/**
	 * 
	 */
	private void create_client() {
		client=new Client();
	}

	/**
	 * 
	 */
	private void create_client_thread() {
		try {
			// System.out.println("async_client = new Thread(new Client());");
			async_client = new Thread(client);
		} catch (NullPointerException e) {
			ChatRoomMemberApplet.GelenKutusu.append("\nNullPointerException");
			System.out.println("NullPointerException");
			e.printStackTrace();
		} catch (IllegalBlockingModeException e) {
			ChatRoomMemberApplet.GelenKutusu.append("\nIllegalBlockingModeException");
			System.out.println("IllegalBlockingModeException");
			e.printStackTrace();
		} catch (Exception e) {
			ChatRoomMemberApplet.GelenKutusu.append("\nException");
			System.out.println("Exception");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private void start_async_client_thread() {
		try {
			// System.out.println("async_client.start();");
			async_client.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the async_client
	 */
	public static Thread getAsync_client() {
		// System.out.println("return async_client;");
		return async_client;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public static void setClient(Client client) {
		ChatRoomMember.client = client;
	}

	/**
	 * @param async_client
	 *            the async_client to set
	 */
	public static void setAsync_client(Thread async_client) {
		// System.out.println("ChatRoomMember.async_client = async_client;");
		ChatRoomMember.async_client = async_client;
	}

}
