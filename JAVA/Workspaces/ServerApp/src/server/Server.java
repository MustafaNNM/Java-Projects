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
import java.util.ConcurrentModificationException;
import java.util.StringTokenizer;
import java.util.Vector;

import gui.server.ChatRoomApplet;

/**
 * @author MehmetAkif-PC
 *
 */
public class Server implements Runnable {

	private static int port_server = 8080;
	private static Boolean port_gecerliligi;
	private static ServerSocket server_socket;
	private static Vector<Socket> received_connection_list;
	private static Vector<String> user_list;
	private static String kullan�c�lar = "";
	private static Vector<ServerHandler> handler_list;
	private static Vector<Thread> thread_list;
	private Thread thread_multi_messagewriter;
	private Multimessagewriter multimessagewriter;

	/**
	 * 
	 */
	public Server() {
		// System.out.println("create_TCP_server();");
		boolean hata_var_m� = false;
		hata_var_m� = create_TCP_server();
		if (hata_var_m� == false) {
			// continue;
		} else {
			// exit
			ChatRoomApplet.GelenKutusu.append("\nServer olu�turulamad�");
			System.out.println("Server olu�turulamad�");
		}
	}

	@Override
	public void run() {
		Boolean hata_var_m� = false;
		if (port_gecerliligi) {
			// System.out.println("Server �al��t�r�l�yor");
			received_connection_list = new Vector<Socket>();
			user_list = new Vector<String>();
			handler_list = new Vector<ServerHandler>();
			thread_list = new Vector<Thread>();
			// System.out.println("wait_for_new_connection();");
			hata_var_m� = wait_for_new_connection();
			if (hata_var_m� == false) {
				// continue;
			} else {
				// exit
				ChatRoomApplet.GelenKutusu.append("\nHata");
				System.out.println("Hata");
			}
		} else {
			hata_var_m� = true;
			ChatRoomApplet.GelenKutusu.append("\nPort ge�ersiz");
			System.out.println("Port ge�ersiz");
		}

	}

	/**
	 * @return
	 * 
	 */
	public static boolean create_TCP_server() {
		Boolean hata_var_m� = false;
		// System.out.println("setPort_gecerliligi(port_numarasi_gecerli_mi(port_server));");
		setPort_gecerliligi(port_numarasi_gecerli_mi(port_server));
		if (getPort_gecerliligi()) {
			try {
				// System.out.println("setSs(new ServerSocket(port_server));");
				setSs(new ServerSocket(port_server));
			} catch (ConnectException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append(
						"\nSignals that an error occurred while attempting to connect a socket to a remote address and port.\nTypically, the connection was refused remotely \n(e.g., no process is listening on the remote address/port).");
				System.out.println(
						"Signals that an error occurred while attempting to connect a socket to a remote address and port. Typically, the connection was refused remotely (e.g., no process is listening on the remote address/port).");
				e.printStackTrace();// cs null
			} catch (InvalidClassException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nInvalidClassException");
				System.out.println("InvalidClassException");
				e.printStackTrace();
			} catch (OptionalDataException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nOptionalDataException");
				System.out.println("OptionalDataException");
				e.printStackTrace();
			} catch (StreamCorruptedException sce) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nStreamCorruptedException");
				System.out.println("StreamCorruptedException");
				try {
					server_socket.close();
				} catch (IOException e1) {
					hata_var_m� = true;
					ChatRoomApplet.GelenKutusu.append("\nIOException");
					System.out.println("IOException");
					e1.printStackTrace();
				}
			} catch (NullPointerException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nNullPointerException");
				System.out.println("NullPointerException");
				e.printStackTrace();
			} catch (BindException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nAddress already in use: JVM_Bind.");
				System.out.println("Address already in use: JVM_Bind.");
				e.printStackTrace();
			} catch (SocketException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nSocketException");
				System.out.println("SocketException");
				e.printStackTrace();
			} catch (UnknownHostException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nThe IP address of the host could not be determined.");
				System.out.println("The IP address of the host could not be determined.");
				e.printStackTrace();
			} catch (IllegalBlockingModeException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nIllegalBlockingModeException");
				System.out.println("IllegalBlockingModeException");
				e.printStackTrace();
			} catch (SocketTimeoutException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nSocketTimeoutException");
				System.out.println("SocketTimeoutException");
				e.printStackTrace();
			} catch (IOException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nIOException");
				System.out.println("IOException");
				e.printStackTrace();
			} catch (Exception e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nException");
				System.out.println("Exception");
				e.printStackTrace();
			}
			// Kullan�c�lar.add(server)
			ChatRoomApplet.GelenKutusu.append("\nserver port \" + port_server + \"'e ba�l� server soket olu�turuldu.");
			System.out.println("server port " + port_server + "'e ba�l� server soket olu�turuldu.");
		} else {
			hata_var_m� = true;
			ChatRoomApplet.GelenKutusu.append("\nServer soket i�in port numarasi gecersiz !");
			System.out.println("Server soket i�in port numarasi gecersiz !");
		}
		return hata_var_m�;
	}

	/**
	 * @return
	 * 
	 */
	public static Boolean wait_for_new_connection() {
		ChatRoomApplet.GelenKutusu.append("\nTCPServer Waiting for clients on port:" + port_server);
		System.out.println("TCPServer Waiting for clients on port:" + port_server);
		Boolean hata_var_m� = false;
		Socket received_socket;
		while (hata_var_m� == false) {// while ba�lang�c�
			try {
				ChatRoomApplet.GelenKutusu.append("\nWaiting for new connection");
				System.out.println("Waiting for new connection");
				// System.out.println("received_connection_list.add(getSs().accept());");
				received_socket = getSs().accept();
				synchronized (received_connection_list) {
					received_connection_list.add(received_socket);
				}
			} // try biti�i
			catch (ConnectException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append(
						"\nSignals that an error occurred while attempting to connect a socket to a remote address and port. Typically, the connection was refused remotely (e.g., no process is listening on the remote address/port).");
				System.out.println(
						"Signals that an error occurred while attempting to connect a socket to a remote address and port. Typically, the connection was refused remotely (e.g., no process is listening on the remote address/port).");
				e.printStackTrace();// cs null
			} // catch biti�i
			catch (InvalidClassException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nInvalidClassException");
				System.out.println("InvalidClassException");
				e.printStackTrace();
			} // catch biti�i
			catch (OptionalDataException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nOptionalDataException");
				System.out.println("OptionalDataException");
				e.printStackTrace();
			} // catch biti�i
			catch (StreamCorruptedException sce) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nStreamCorruptedException");
				System.out.println("StreamCorruptedException");
				try {
					server_socket.close();
				} catch (IOException e1) {
					hata_var_m� = true;
					ChatRoomApplet.GelenKutusu.append("\nIOException");
					System.out.println("IOException");
					e1.printStackTrace();
				} // catch biti�i
			} // catch biti�i
			catch (NullPointerException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nNullPointerException");
				System.out.println("NullPointerException");
				e.printStackTrace();
			} // catch biti�i
			catch (SocketException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nSocketException");
				System.out.println("SocketException");
				e.printStackTrace();
			} // catch biti�i
			catch (UnknownHostException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nThe IP address of the host could not be determined.");
				System.out.println("The IP address of the host could not be determined.");
				e.printStackTrace();
			} // catch biti�i
			catch (IllegalBlockingModeException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nIllegalBlockingModeException");
				System.out.println("IllegalBlockingModeException");
				e.printStackTrace();
			} // catch biti�i
			catch (SocketTimeoutException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nSocketTimeoutException");
				System.out.println("SocketTimeoutException");
				e.printStackTrace();
			} // catch biti�i
			catch (IOException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nIOException");
				System.out.println("IOException");
				e.printStackTrace();
			} // catch biti�i
			catch (Exception e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nException");
				System.out.println("Exception");
				e.printStackTrace();
			} // catch biti�i
				// hash table gerek galiba Soket
				// kapatilinca gelen_baglantilar_listesinden
				// kaldirilmalidir
				// System.out.println("Soket ba�lant� listesine eklendi");
				// ChatRoomApplet.GelenKutusu.append(
				// "\n" +
				// received_connection_list.lastElement().getLocalAddress()
				// + received_connection_list.lastElement().getPort() + "
				// ba�land�.");
				// // kar�� tarafa ba�land� mesaj�n�n gitmesi gerekiyor
			if (hata_var_m� == false) {
				user_list.add("" + received_connection_list.lastElement().getLocalAddress() + ":"
						+ received_connection_list.lastElement().getPort());
				kullan�c�lar = kullan�c�lar�_guncelle();
				ChatRoomApplet.Kullan�c�lar.setText(kullan�c�lar);
				System.out.println("Gelen ba�lant� adresi:" + received_connection_list.lastElement().getLocalAddress()
						+ "Gelen ba�lant� portu:" + received_connection_list.lastElement().getPort());
				try {
					/*
					 * System.out.println("thread_list.add(new Thread(\r\n" +
					 * "						new ServerHandler(received_connection_list, received_connection_list.lastElement())));"
					 * );
					 */thread_list.add(new Thread(new ServerHandler(received_connection_list,
							received_connection_list.lastElement(), user_list)));
					// new ServerHandler nesnesi olu�turmak gerekebilir
				} catch (Exception e) {
					hata_var_m� = true;
					ChatRoomApplet.GelenKutusu.append("\nHata var !");
					System.out.println("Hata var !");
					e.printStackTrace();
				} // catch biti�i
				if (hata_var_m� == false) {
					try {
						// System.out.println("thread_list.lastElement().start();");
						thread_list.lastElement().start();
					} catch (NullPointerException e) {
						hata_var_m� = true;
						ChatRoomApplet.GelenKutusu.append("\nNullPointerException");
						System.out.println("NullPointerException");
						e.printStackTrace();
					} // catch biti�i
					catch (IllegalBlockingModeException e) {
						hata_var_m� = true;
						ChatRoomApplet.GelenKutusu.append("\nIllegalBlockingModeException");
						System.out.println("IllegalBlockingModeException");
						e.printStackTrace();
					} // catch biti�i
					catch (Exception e) {
						hata_var_m� = true;
						ChatRoomApplet.GelenKutusu.append("\nThread listteki son eleman ba�lat�lamad�!");
						System.out.println("Thread listteki son eleman ba�lat�lamad�!");
						e.printStackTrace();
					} // catch biti�i
				} else {
					// exit
					// ChatRoomApplet.GelenKutusu.append("\nHata");
					// System.out.println("Hata");
				}
			} else {
				ChatRoomApplet.GelenKutusu.append("\nYeni ba�lant� beklerken hata olu�tu");
				System.out.println("Yeni ba�lant� beklerken hata olu�tu");
			}
		} // while biti�i
		if (hata_var_m� == true) {
			try {
				// received_connection_list teki t�m ba�lant�lar�n kapat�lmas�
				// gerekiyor.
				hata_var_m� = tum_baglant�lar�_kapat(received_connection_list);
				user_list = null;// user_list in temizlenmesi gerekiyor.
				hata_var_m� = tum_threadleri_kapat(thread_list);
				thread_list = null;
				// thread_list teki t�m threadlerin kapat�lmas� gerekiyor.
				// System.out.println("getSs().close();");
				server_socket.close(); // close server socket
			} // try biti�i
			catch (IOException ioException) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nIllegalBlockingModeException");
				System.out.println("IllegalBlockingModeException");
				ioException.printStackTrace();
			} // catch biti�i
			catch (Exception Exception) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nException");
				System.out.println("Exception");
				Exception.printStackTrace();
			} // catch biti�i
			return hata_var_m�;
		} else {
			// exit
			ChatRoomApplet.GelenKutusu.append("\nHata");
			System.out.println("Hata");
			return hata_var_m�;
		}
	}

	private static Boolean tum_threadleri_kapat(Vector<Thread> thread_list2) {
		Boolean hata_var_m� = false;
		for (Thread thread : thread_list2) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				hata_var_m� = true;
				ChatRoomApplet.GelenKutusu.append("\nInterruptedException");
				System.out.println("InterruptedException");
				e.printStackTrace();
			}
		}
		return hata_var_m�;
	}

	private static Boolean tum_baglant�lar�_kapat(Vector<Socket> received_connection_list2) {
		Boolean hata_var_m� = false;
		if (hata_var_m� == false) {
			for (Socket s : received_connection_list2) {
				if (s != null) {
					try {
						s.close();
					} catch (IOException e) {
						hata_var_m� = true;
						ChatRoomApplet.GelenKutusu.append("\nIOException");
						System.out.println("IOException");
						e.printStackTrace();
					} catch (Exception e) {
						hata_var_m� = true;
						ChatRoomApplet.GelenKutusu.append("\nException");
						System.out.println("Exception");
						e.printStackTrace();
					}
				}
			}
			if (hata_var_m� == true) {
				ChatRoomApplet.GelenKutusu.append("\nSoket kapatma i�lemi yap�l�rken hata olu�tu");
				System.out.println("Soket kapatma i�lemi yap�l�rken hata olu�tu");
			} else {
				// hata yok durmak yok yola devam
				ChatRoomApplet.Kullan�c�lar.setText("");// Kullan�c�lar
														// kapat�ld�.
			}
			return hata_var_m�;
		} else {
			// exit
			ChatRoomApplet.GelenKutusu.append("\nHata");
			System.out.println("Hata");
			return hata_var_m�;
		}
	}

	/**
	 * @return
	 */
	public static String kullan�c�lar�_guncelle() {
		String kullan�c�lar = "";
		if (user_list != null && user_list.size() != 0) {
			for (String kullan�c� : user_list) {
				kullan�c�lar += kullan�c� + "\n";
			}
		}
		return kullan�c�lar;
	}

	/**
	 * @param port2
	 * @return
	 */
	private static Boolean port_numarasi_gecerli_mi(int port2) {
		Boolean yanit = null;
		if (1024 < port2 && port2 < 65535) {
			yanit = true;
			return yanit;
		} else {
			ChatRoomApplet.GelenKutusu.append(
					"\nThe port parameter is outside the specified range of valid port values,\nwhich is between 0 and 65535,\ninclusive.");
			System.out.println(
					"The port parameter is outside the specified range of valid port values, which is between 0 and 65535, inclusive.");
			yanit = false;
			return yanit;
		}
	}

	public Boolean create_multi_message_writer_thread(String message) {
		Boolean hata_var_m� = false;
		/*
		 * System.out.println(
		 * "thread_multi_messagewriter = new Thread(new Multimessagewriter(received_connection_list, message));"
		 * );
		 */
		multimessagewriter = new Multimessagewriter(received_connection_list, message);
		if (multimessagewriter != null) {
			try {
				thread_multi_messagewriter = new Thread(multimessagewriter);// Serverdan
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
			if (thread_multi_messagewriter != null) {
				try {
					System.out.println("thread_multi_messagewriter.start();");
					thread_multi_messagewriter.start();
					System.out.println("thread_multi_messagewriter.started");
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

		} else {
			hata_var_m� = true;
		}
		return hata_var_m�;

	}

	/**
	 * @return the ss
	 */
	public static ServerSocket getSs() {
		return server_socket;
	}

	/**
	 * @param ss
	 */
	public static void setSs(ServerSocket ss) {
		server_socket = ss;
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
	public static Vector<Socket> getReceived_connection_list() {
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
	 * @return the port_server
	 */
	public static int getPort_server() {
		return port_server;
	}

	/**
	 * @param port_server
	 *            the port_server to set
	 */
	public static void setPort_server(int port_server) {
		Server.port_server = port_server;
	}

	/**
	 * @return the thread_multi_messagewriter
	 */
	public Thread getThread_multi_messagewriter() {
		return thread_multi_messagewriter;
	}

	/**
	 * @param thread_multi_messagewriter
	 *            the thread_multi_messagewriter to set
	 */
	public void setThread_multi_messagewriter(Thread thread_multi_messagewriter) {
		this.thread_multi_messagewriter = thread_multi_messagewriter;
	}

	/**
	 * @return the multimessagewriter
	 */
	public Multimessagewriter getMultimessagewriter() {
		return multimessagewriter;
	}

	/**
	 * @param multimessagewriter
	 *            the multimessagewriter to set
	 */
	public void setMultimessagewriter(Multimessagewriter multimessagewriter) {
		this.multimessagewriter = multimessagewriter;
	}

	/**
	 * @param thread_list
	 *            the thread_list to set
	 */
	public static void setThread_list(Vector<Thread> thread_list) {
		Server.thread_list = thread_list;
	}

	/**
	 * @return the user_list
	 */
	public static Vector<String> getUser_list() {
		return user_list;
	}

	/**
	 * @param user_list
	 *            the user_list to set
	 */
	public static void setUser_list(Vector<String> user_list) {
		Server.user_list = user_list;
	}

	/**
	 * @return the kullan�c�lar
	 */
	public static String getKullan�c�lar() {
		return kullan�c�lar;
	}

	/**
	 * @param kullan�c�lar
	 *            the kullan�c�lar to set
	 */
	public static void setKullan�c�lar(String kullan�c�lar) {
		Server.kullan�c�lar = kullan�c�lar;
	}

	public Boolean kick(String message) {
		Boolean hata_var_m� = false;
		String search = message.substring(5);
		String url = "";
		String port = "";
		System.out.println(search + "kick yap�lacak in�allah");
		StringTokenizer st = new StringTokenizer(search, ":");
		if (st.hasMoreElements()) {
			url = (String) st.nextElement();
			System.out.println("url:" + url);
			if (st.hasMoreElements()) {
				port = (String) st.nextElement();
				System.out.println("port:" + port);
			}
		}
		int bas = 0;
		int son = received_connection_list.size();
		Socket s;
		for (bas = 0; bas < son; bas++) {
			s = received_connection_list.elementAt(bas);
			if (s.getLocalAddress().toString().equals(url) && ("" + s.getPort()).equals(port)) {
				received_connection_list.removeElementAt(bas);
				System.out.println("kick i�lemi ba�ar�l�");
				synchronized (Server.getUser_list()) {
					if (Server.getUser_list() != null) {
						System.out.println("user_list is not null");
						Server.setUser_list(new Vector<String>());// Broadcaster
						ChatRoomApplet.Kullan�c�lar.setText("Liste g�ncelleniyor!"); // olmas�
						// laz�m
						synchronized (Server.getReceived_connection_list()) {
							int i = 0;
							try {
								if (Server.getReceived_connection_list() != null
										&& Server.getReceived_connection_list().size() != 0) {
									System.out.println("message_receiver_socket_list is not null");
									int size = Server.getReceived_connection_list().size();
									for (i = 0; i < size; i++) {
										Socket socket = Server.getReceived_connection_list().elementAt(i);
										if (socket != null) {
											if (socket.isClosed()) {
												System.out.println("socket is Closed");
												// ChatRoomApplet.GelenKutusu.append("\nKullan�c�
												// ayr�ld�hahaha");
												// ChatRoomApplet.Kullan�c�lar.append("\nKullan�c�
												// ayr�ld�hahaha");
												// System.out.println("Kullan�c�
												// ayr�ld�hahaha");
												// kullan�c�lar�
												// g�ncelle
												// message_receiver_socket_list.removeElementAt(i);
												// i--;
											} else {
												System.out.println("socket is open");
												// i++;
												Server.getUser_list().add("" + socket.getLocalAddress() + ":" + socket.getPort());
											}
										} else {
											System.out.println("s is null");
											// message_receiver_socket_list.removeElementAt(i);
											// i--;
										}
									}
									ChatRoomApplet.Kullan�c�lar.setText(Server.kullan�c�lar�_guncelle());
								} else {
									System.out.println("message_receiver_socket_list is null or zero");
									ChatRoomApplet.Kullan�c�lar.setText("");
								}
							} catch (ConcurrentModificationException con) {
								hata_var_m� = true;
								System.out.println("ConcurrentModificationException");
								ChatRoomApplet.GelenKutusu.append("\nConcurrentModificationException");
								con.printStackTrace();
							}
						}
					} else {
						System.out.println("user_list is null");
						// kullan�c�lar = "";
						ChatRoomApplet.Kullan�c�lar.setText("");
					}

				}
			} else {
				System.out.println("e�it de�ilmi� kikc ile �yle mi ?:" + s.getLocalAddress() + ":" + s.getLocalPort());
			}
		}

		return hata_var_m�;
	}

}
