package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.channels.IllegalBlockingModeException;
import java.util.Vector;

public class ServerHandler implements Runnable {
	private Vector<Socket> message_receiver_socket_list = null;
	private InputStream soketinputstream = null;
	private Socket socket_to_listen = null;
	private String line = null;
	private Thread thread_multi_messagewriter = null;

	public ServerHandler(Vector<Socket> message_receiver_socket_list, Socket socket_to_listen) {
		//System.out.println("Server Handler oluþturuluyor");
		this.message_receiver_socket_list = message_receiver_socket_list;
		this.socket_to_listen = socket_to_listen;
		// multimessageprinter kullaanýlabilinir
	}

	public void run() {
		//System.out.println("Server Handler çalýþtýrýlýyor");
		create_multi_message_writer_thread();
	}

	/**
	 * @param socket
	 */
	private void create_multi_message_writer_thread() {
		//System.out.println("create_multi_message_writer_thread");
		if (socket_to_listen != null) {
			//System.out.println("try_setting_soket_input_stream();");
			try_setting_soket_input_stream();
			if (soketinputstream != null) {
				//System.out.println("create_thread_multi_messagewriter();");
				create_thread_multi_messagewriter();
				if (thread_multi_messagewriter != null) {
					//System.out.println("start_thread_multi_message_writer();");
					start_thread_multi_message_writer();
				}
			} else {
				System.out.println("thread baþlatýlamadý");
			}
		} else {
			System.out.println("socket_to_listen null");
		}
	}

	/**
	 * 
	 */
	private void start_thread_multi_message_writer() {
		try {
			//System.out.println("thread_messageprinter.start();");
			thread_multi_messagewriter.start();
			//System.out.println("thread_messageprinter.started");
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
	private void create_thread_multi_messagewriter() {
		try {
			System.out.println(
					"thread_messagewriter = new Thread(new Multimessagewriter(message_receiver_socket_list,soketinputstream));");
			thread_multi_messagewriter = new Thread(
					new Multimessagewriter(message_receiver_socket_list, soketinputstream));
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
	private void try_setting_soket_input_stream() {
		try {
			System.out.println("soketinputstream = socket.getInputStream();");
			soketinputstream = socket_to_listen.getInputStream();
		} catch (ConnectException e) {
			System.out.println(
					"Signals that an error occurred while attempting to connect a socket to a remote address and port. Typically, the connection was refused remotely (e.g., no process is listening on the remote address/port).");
			e.printStackTrace();// cs null
		} catch (InvalidClassException e) {
			System.out.println("InvalidClassException");
			e.printStackTrace();
		} catch (OptionalDataException e) {
			System.out.println("OptionalDataException");
			e.printStackTrace();
		} catch (StreamCorruptedException sce) {
			System.out.println("StreamCorruptedException");
			sce.printStackTrace();
			System.out.println("close_socket_to_listen();");
			close_socket_to_listen();
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
			e.printStackTrace();
		} catch (BindException e) {
			System.out.println("Address already in use: JVM_Bind.");
			e.printStackTrace();
		} catch (SocketException e) {
			System.out.println("SocketException");
			e.printStackTrace();
		} catch (UnknownHostException e) {
			System.out.println("The IP address of the host could not be determined.");
			e.printStackTrace();
		} catch (IllegalBlockingModeException e) {
			System.out.println("IllegalBlockingModeException");
			e.printStackTrace();
		} catch (SocketTimeoutException e) {
			System.out.println("SocketTimeoutException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private void close_socket_to_listen() {
		try {
			System.out.println("socket.close();");
			socket_to_listen.close();
		} catch (IOException e1) {
			System.out.println("IOException");
			e1.printStackTrace();
		}
	}

	/**
	 * @return the line
	 */
	public String getLine() {
		return line;
	}

	/**
	 * @param line
	 *            the line to set
	 */
	public void setLine(String line) {
		this.line = line;
	}

}
