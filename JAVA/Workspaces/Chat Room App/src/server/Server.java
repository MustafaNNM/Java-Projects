/**
 * 
 */
package server;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.channels.IllegalBlockingModeException;
import java.util.Vector;

/**
 * @author MehmetAkif-PC
 *
 */
public class Server implements Runnable {

	private static int port_server = 8080;
	private static Boolean port_gecerliligi;
	private static ServerSocket ss;
	private static Vector<Socket> received_connection_list;
	private static Vector<ServerHandler> handler_list;
	private static Vector<Thread> thread_list;

	/**
	 * 
	 */
	public Server() {
		//System.out.println("create_TCP_server();");
		create_TCP_server();
	}

	@Override
	public void run() {
		//System.out.println("Server çalýþtýrýlýyor");
		received_connection_list = new Vector<Socket>();
		handler_list = new Vector<ServerHandler>();
		thread_list = new Vector<Thread>();
		//System.out.println("wait_for_new_connection();");
		wait_for_new_connection();
	}

	/**
	 * 
	 */
	public static void create_TCP_server() {
		//System.out.println("setPort_gecerliligi(port_numarasi_gecerli_mi(port_server));");
		setPort_gecerliligi(port_numarasi_gecerli_mi(port_server));
		try {
			if (getPort_gecerliligi()) {
				//System.out.println("setSs(new ServerSocket(port_server));");
				setSs(new ServerSocket(port_server));
				System.out.println("server port " + port_server + "'e baðlý server soket oluþturuldu.");
			} else {
				System.out.println("Server soket için port numarasi gecersiz !");
			}
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
			try {
				ss.close();
			} catch (IOException e1) {
				System.out.println("IOException");
				e1.printStackTrace();
			}
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
	public static void wait_for_new_connection() {
		System.out.println("TCPServer Waiting for clients on port:" + port_server);
		Boolean hata_var_mý = false;
		while (hata_var_mý == false) {// while baþlangýcý
			try {
				System.out.println("Waiting for new connection");
				//System.out.println("received_connection_list.add(getSs().accept());");
				received_connection_list.add(getSs().accept());// hash table
																// gerek
																// galiba Soket
																// kapatilinca
																// gelen_baglantilar_listesinden
																// kaldirilmalidir
				//System.out.println("Soket baðlantý listesine eklendi");
				System.out.println("Gelen baðlantý adresi:" + received_connection_list.lastElement().getLocalAddress()+"Gelen baðlantý portu:"+received_connection_list.lastElement().getPort());
	
			} // try bitiþi
			catch (ConnectException e) {
				hata_var_mý = true;
				System.out.println(
						"Signals that an error occurred while attempting to connect a socket to a remote address and port. Typically, the connection was refused remotely (e.g., no process is listening on the remote address/port).");
				e.printStackTrace();// cs null
			} // catch bitiþi
			catch (InvalidClassException e) {
				hata_var_mý = true;
				System.out.println("InvalidClassException");
				e.printStackTrace();
			} // catch bitiþi
			catch (OptionalDataException e) {
				hata_var_mý = true;
				System.out.println("OptionalDataException");
				e.printStackTrace();
			}// catch bitiþi
			catch (StreamCorruptedException sce) {
				hata_var_mý = true;
				System.out.println("StreamCorruptedException");
				try {
					ss.close();
				} catch (IOException e1) {
					hata_var_mý = true;
					System.out.println("IOException");
					e1.printStackTrace();
				}// catch bitiþi
			}// catch bitiþi 
			catch (NullPointerException e) {
				hata_var_mý = true;
				System.out.println("NullPointerException");
				e.printStackTrace();
			}// catch bitiþi 
			catch (SocketException e) {
				hata_var_mý = true;
				System.out.println("SocketException");
				e.printStackTrace();
			}// catch bitiþi 
			catch (UnknownHostException e) {
				hata_var_mý = true;
				System.out.println("The IP address of the host could not be determined.");
				e.printStackTrace();
			}// catch bitiþi
			catch (IllegalBlockingModeException e) {
				hata_var_mý = true;
				System.out.println("IllegalBlockingModeException");
				e.printStackTrace();
			}// catch bitiþi 
			catch (SocketTimeoutException e) {
				hata_var_mý = true;
				System.out.println("SocketTimeoutException");
				e.printStackTrace();
			}// catch bitiþi
			catch (IOException e) {
				hata_var_mý = true;
				System.out.println("IOException");
				e.printStackTrace();
			}// catch bitiþi 
			catch (Exception e) {
				hata_var_mý = true;
				System.out.println("Exception");
				e.printStackTrace();
			}// catch bitiþi

			try {
				/*System.out.println("thread_list.add(new Thread(\r\n" + 
						"						new ServerHandler(received_connection_list, received_connection_list.lastElement())));");
				*/
				thread_list.add(new Thread(
						new ServerHandler(received_connection_list, received_connection_list.lastElement())));
			} catch (Exception e) {
				hata_var_mý = true;
				System.out.println("Hata var !");
				e.printStackTrace();
			}// catch bitiþi

			try {
				//System.out.println("thread_list.lastElement().start();");
				thread_list.lastElement().start();
			} catch (NullPointerException e) {
				hata_var_mý = true;
				System.out.println("NullPointerException");
				e.printStackTrace();
			}// catch bitiþi
			catch (IllegalBlockingModeException e) {
				hata_var_mý = true;
				System.out.println("IllegalBlockingModeException");
				e.printStackTrace();
			}// catch bitiþi
			catch (Exception e) {
				hata_var_mý = true;
				System.out.println("Thread listteki son eleman baþlatýlamadý!");
				e.printStackTrace();
			}// catch bitiþi

		} // while bitiþi

		try {
			//System.out.println("getSs().close();");
			getSs().close(); // close server socket
		} // try bitiþi
		catch (IOException ioException) {
			ioException.printStackTrace();
		} // catch bitiþi
	}

	/**
	 * @param port2
	 * @return
	 */
	private static Boolean port_numarasi_gecerli_mi(int port2) {
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

	/**
	 * @return the ss
	 */
	public static ServerSocket getSs() {
		return ss;
	}

	/**
	 * @param ss
	 */
	public static void setSs(ServerSocket ss) {
		Server.ss = ss;
	}

	/**
	 * @return the port_gecerliligi
	 */
	public static Boolean getPort_gecerliligi() {
		return port_gecerliligi;
	}

	/**
	 * @param port_gecerliligi
	 */
	public static void setPort_gecerliligi(Boolean port_gecerliligi) {
		Server.port_gecerliligi = port_gecerliligi;
	}

	/**
	 * @return the received_connection_list
	 */
	public Vector<Socket> getReceived_connection_list() {
		return received_connection_list;
	}

	/**
	 * @param received_connection_list
	 *            the received_connection_list to set
	 */
	public void setReceived_connection_list(Vector<Socket> received_connection_list) {
		Server.received_connection_list = received_connection_list;
	}

	/**
	 * @return the handler_list
	 */
	public static Vector<ServerHandler> getHandler_list() {
		return handler_list;
	}

	/**
	 * @param handler_list
	 *            the handler_list to set
	 */
	public static void setHandler_list(Vector<ServerHandler> handler_list) {
		Server.handler_list = handler_list;
	}

	/**
	 * @return the thread_list
	 */
	public static Vector<Thread> getThread_list() {
		return thread_list;
	}

	/**
	 * @param thread_list
	 *            the thread_list to set
	 */
	public static void setThread_list(Vector<Thread> thread_list) {
		Server.thread_list = thread_list;
	}

}
