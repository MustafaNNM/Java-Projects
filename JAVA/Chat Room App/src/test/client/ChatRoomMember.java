package test.client;

import java.nio.channels.IllegalBlockingModeException;

import client.Client;

public class ChatRoomMember {
	private static Thread async_client;

	public ChatRoomMember() {
		//System.out.println("ChatRoomMember oluþturuluyor.");
		//System.out.println("create_async_client();");
		create_async_client();
		System.out.println("start_async_client();");
		start_async_client();
		System.out.println("async_client.started");
	}

	/**
	 * 
	 */
	private void create_async_client() {
		try {
			System.out.println("async_client = new Thread(new Client());");
			async_client = new Thread(new Client());
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
			e.printStackTrace();
		} catch (IllegalBlockingModeException e) {
			System.out.println("IllegalBlockingModeException");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private void start_async_client() {
		try {
			System.out.println("async_client.start();");
			async_client.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("ChatRoomMember chatRoomMember=new ChatRoomMember();");
		@SuppressWarnings("unused")
		ChatRoomMember chatRoomMember=new ChatRoomMember();
	}

	/**
	 * @return the async_client
	 */
	public static Thread getAsync_client() {
		System.out.println("return async_client;");
		return async_client;
	}

	/**
	 * @param async_client
	 *            the async_client to set
	 */
	public static void setAsync_client(Thread async_client) {
		System.out.println("ChatRoomMember.async_client = async_client;");
		ChatRoomMember.async_client = async_client;
	}

}
