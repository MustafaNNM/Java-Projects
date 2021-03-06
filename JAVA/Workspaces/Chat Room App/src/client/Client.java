/**
 * 
 */
package client;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.channels.IllegalBlockingModeException;

/**
 * @author MehmetAkif-PC
 *
 */

public class Client implements Runnable {

	private static int port = 8080;
	private static Boolean port_gecerliligi;
	private static Boolean host_gecerliligi;
	private static String host = "localhost";
	private static Socket s = null;
	private static Thread thread_SocketListener;
	private static Thread thread_SocketWriter;

	/**
	 * 
	 */
	public Client() {
		System.out.println("Client oluşturuluyor consructor");
	}

	@Override
	public void run() {
		System.out.println("Client.run çalıştırılıyor");
		System.out.println("setPort_gecerliligi(port_numarasi_gecerli_mi(port));");
		setPort_gecerliligi(port_numarasi_gecerli_mi(port));
		System.out.println("setHost_gecerliligi(host_adresi_gecerli_mi(host));");
		setHost_gecerliligi(host_adresi_gecerli_mi(host));
		System.out.println("create_TCP_client_and_make_connection();");
		create_TCP_client_and_make_connection();
	}

	private static Boolean port_numarasi_gecerli_mi(int port2) {
		System.out.println("port_numarasi_gecerli_mi");
		Boolean yanit = null;
		if (1024 < port2 && port2 < 65535) {
			yanit = true;
		} else {
			System.out.println(
					"The port parameter is outside the specified range of valid port values, which is between 0 and 65535, inclusive.");
			yanit = false;
		}
		return yanit;
	}

	private static Boolean host_adresi_gecerli_mi(String host2) {
		System.out.println("host_adresi_gecerli_mi");
		Boolean yanit = null;
		if (host2 == null) {
			System.out.println("Host gecersiz.");
			yanit = false;
		} else {
			yanit = true;
		}
		return yanit;
	}

	public void create_TCP_client_and_make_connection() {
		System.out.println("create_TCP_client_and_make_connection");
		System.out.println("getPort_gecerliligi() == true && getHost_gecerliligi() == true");
		if (getPort_gecerliligi() == true && getHost_gecerliligi() == true) {
			System.out.println("s = create_socket(s);");
			s = create_socket(s);
			System.out.println("create_thread_SocketListener();");
			create_thread_SocketListener();
			System.out.println("create_thread_SocketWriter();");
			create_thread_SocketWriter();
		} else {
			System.out.println("Port numarasi veya host gecersiz !");
		}
		System.out.println("start_thread_SocketListener();");
		start_thread_SocketListener();
		System.out.println("start_thread_SocketWriter();");
		start_thread_SocketWriter();
	}

	/**
	 * @param s
	 * @return
	 */
	private Socket create_socket(Socket s) {
		try {
			System.out.println("s=new Socket(host, port);");
			s = new Socket(host, port);
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
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
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
		return s;
	}
	

	/**
	 * 
	 */
	private void create_thread_SocketWriter() {
		try {
			System.out.println("thread_SocketWriter=new Thread(new SocketWriter(s.getOutputStream()));");
			thread_SocketWriter = new Thread(new SocketWriter(s.getOutputStream()));
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
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
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
	private void create_thread_SocketListener() {
		try {
			System.out.println("thread_SocketListener=new Thread(new SocketListener(s.getInputStream()));");
			thread_SocketListener = new Thread(new SocketListener(s.getInputStream()));
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
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
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
	private void start_thread_SocketWriter() {
		try {
			System.out.println("thread_SocketWriter.start();");
			thread_SocketWriter.start();
			System.out.println("thread_SocketWriter.started");
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
	private void start_thread_SocketListener() {
		try {
			System.out.println("thread_SocketListener.start();");
			thread_SocketListener.start();
			System.out.println("thread_SocketListener.started");
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
	 * @return the port
	 */
	public static int getPort() {
		return port;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public static void setPort(int port) {
		Client.port = port;
	}

	/**
	 * @return the port_gecerliligi
	 */
	public static Boolean getPort_gecerliligi() {
		return port_gecerliligi;
	}

	/**
	 * @param port_gecerliligi
	 *            the port_gecerliligi to set
	 */
	public static void setPort_gecerliligi(Boolean port_gecerliligi) {
		Client.port_gecerliligi = port_gecerliligi;
	}

	/**
	 * @return the host_gecerliligi
	 */
	public static Boolean getHost_gecerliligi() {
		return host_gecerliligi;
	}

	/**
	 * @param host_gecerliligi
	 *            the host_gecerliligi to set
	 */
	public static void setHost_gecerliligi(Boolean host_gecerliligi) {
		Client.host_gecerliligi = host_gecerliligi;
	}

	/**
	 * @return the thread
	 */
	public static Thread getThread() {
		return thread_SocketListener;
	}

	/**
	 * @param thread
	 *            the thread to set
	 */
	public static void setThread(Thread thread) {
		Client.thread_SocketListener = thread;
	}

	/**
	 * @return the thread_SocketWriter
	 */
	public static Thread getThread_SocketWriter() {
		return thread_SocketWriter;
	}

	/**
	 * @return the host
	 */
	public static String getHost() {
		return host;
	}

	/**
	 * @param host
	 *            the host to set
	 */
	public static void setHost(String host) {
		Client.host = host;
	}

	/**
	 * @return the s
	 */
	public static Socket getS() {
		return s;
	}

	/**
	 * @param s
	 *            the s to set
	 */
	public static void setS(Socket s) {
		Client.s = s;
	}

	/**
	 * @return the thread_SocketListener
	 */
	public static Thread getThread_SocketListener() {
		return thread_SocketListener;
	}

	/**
	 * @param thread_SocketListener
	 *            the thread_SocketListener to set
	 */
	public static void setThread_SocketListener(Thread thread_SocketListener) {
		Client.thread_SocketListener = thread_SocketListener;
	}

	/**
	 * @param thread_SocketWriter
	 *            the thread_SocketWriter to set
	 */
	public static void setThread_SocketWriter(Thread thread_SocketWriter) {
		Client.thread_SocketWriter = thread_SocketWriter;
	}

}
