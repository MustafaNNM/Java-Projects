/**
 * 
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InvalidClassException;
import java.io.OptionalDataException;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.channels.IllegalBlockingModeException;
import java.util.ConcurrentModificationException;
import java.util.Vector;

import gui.server.ChatRoomApplet;

public class Broadcaster implements Runnable {
	private InputStream soketinputstream = null;
	private Vector<Socket> message_receiver_socket_list = null;
	private static String kullanýcýlar = "";

	public Broadcaster(Vector<Socket> message_receiver_socket_list, InputStream soketinputstream) {
		@SuppressWarnings("unused")
		boolean hata_var_mý = false;
		// System.out.println("Messageprinter oluþturuluyor");
		if (message_receiver_socket_list != null) {
			this.message_receiver_socket_list = message_receiver_socket_list;
			if (soketinputstream != null) {
				this.setSoketinputstream(soketinputstream);
			} else {
				hata_var_mý = true;
				ChatRoomApplet.GelenKutusu.append("\nMessageprinter oluþturulamadi");
				System.out.println("Messageprinter oluþturulamadi");
			}
		} else {
			hata_var_mý = true;
			System.out.println("message_receiver_socket_list is null");
		}
	}

	@Override
	public void run() {
		// System.out.println("Multimessagewriter.run çalýþtýrýlýyor");
		// System.out.println("soketinputstream != null");
		boolean hata_var_mý = false;
		if (soketinputstream != null) {
			// System.out.println("InputStreamReader inputstreamreader = new
			// InputStreamReader(soketinputstream);");
			InputStreamReader inputstreamreader = new InputStreamReader(soketinputstream);
			// System.out.println("inputstreamreader != null");
			if (inputstreamreader != null) {
				// System.out.println("BufferedReader inFromClient = new
				// BufferedReader(inputstreamreader);");
				BufferedReader inFromClient = new BufferedReader(inputstreamreader);
				// System.out.println("inFromClient != null");
				if (inFromClient != null) {
					String clientSentence = "";
					// System.out.println("donguye giriliyor");
					while (hata_var_mý == false) {
						try {
							// System.out.println("clientSentence =
							// inFromClient.readLine();");
							clientSentence = inFromClient.readLine();
						} catch (ConnectException e) {
							hata_var_mý = true;
							ChatRoomApplet.GelenKutusu.append(
									"\nSignals that an error occurred while attempting to connect a socket to a remote address and port. Typically, the connection was refused remotely (e.g., no process is listening on the remote address/port).");
							System.out.println(
									"Signals that an error occurred while attempting to connect a socket to a remote address and port. Typically, the connection was refused remotely (e.g., no process is listening on the remote address/port).");
							e.printStackTrace();// cs null
						} catch (InvalidClassException e) {
							hata_var_mý = true;
							ChatRoomApplet.GelenKutusu.append("\nInvalidClassException");
							System.out.println("InvalidClassException");
							e.printStackTrace();
						} catch (OptionalDataException e) {
							hata_var_mý = true;
							ChatRoomApplet.GelenKutusu.append("\nOptionalDataException");
							System.out.println("OptionalDataException");
							e.printStackTrace();
						} catch (StreamCorruptedException sce) {
							hata_var_mý = true;
							ChatRoomApplet.GelenKutusu.append("\nStreamCorruptedException");
							System.out.println("StreamCorruptedException");
							sce.printStackTrace();
						} catch (NullPointerException e) {
							hata_var_mý = true;
							ChatRoomApplet.GelenKutusu.append("\nNullPointerException");
							System.out.println("NullPointerException");
							e.printStackTrace();
						} catch (SocketException e) {
							hata_var_mý = true;
							// e.printStackTrace();
							try {
								soketinputstream.close();
								inputstreamreader.close();
								inFromClient.close();
								synchronized (Server.getUser_list()) {
									if (Server.getUser_list() != null) {
										System.out.println("user_list is not null");
										Server.setUser_list(new Vector<String>());// Broadcaster
																						// olmasý
																						// lazým
										synchronized ( Server.getReceived_connection_list()) {
											int i = 0;
											try {
												if ( Server.getReceived_connection_list() != null
														&& Server.getReceived_connection_list().size() != 0) {
													System.out.println("message_receiver_socket_list is not null");
													int size= Server.getReceived_connection_list().size();
													for (i = 0; i < size; i++) {
														Socket s = Server.getReceived_connection_list().elementAt(i);
														if (s != null) {
															if (s.isClosed()) {
																System.out.println("s is Closed");
																// ChatRoomApplet.GelenKutusu.append("\nKullanýcý
																// ayrýldýhahaha");
																// ChatRoomApplet.Kullanýcýlar.append("\nKullanýcý
																// ayrýldýhahaha");
																// System.out.println("Kullanýcý
																// ayrýldýhahaha");
																// kullanýcýlarý
																// güncelle
																// message_receiver_socket_list.removeElementAt(i);
																// i--;
															} else {
																System.out.println("s is open");
																// i++;
																Server.getUser_list().add(
																		"" + s.getLocalAddress() + ":" + s.getPort());
															}
														} else {
															System.out.println("s is null");
															// message_receiver_socket_list.removeElementAt(i);
															// i--;
														}
													}
													setKullanýcýlar(kullanýcýlarý_guncelle());
													ChatRoomApplet.Kullanýcýlar.setText(kullanýcýlar);
												} else {
													System.out.println("message_receiver_socket_list is null");
												}
											} catch (ConcurrentModificationException con) {
												hata_var_mý = true;
												System.out.println("ConcurrentModificationException");
												ChatRoomApplet.GelenKutusu.append("\nConcurrentModificationException");
												con.printStackTrace();
											}
										}
									} else {
										System.out.println("user_list is null");
										kullanýcýlar = "";
										ChatRoomApplet.Kullanýcýlar.setText("");
									}
								}
							} catch (IOException e1) {
								hata_var_mý = true;
								ChatRoomApplet.GelenKutusu.append("\nIOException");
								System.out.println("IOException");
								e1.printStackTrace();
							}
						} catch (UnknownHostException e) {
							hata_var_mý = true;
							ChatRoomApplet.GelenKutusu.append("\nThe IP address of the host could not be determined.");
							System.out.println("The IP address of the host could not be determined.");
							e.printStackTrace();
						} catch (IllegalBlockingModeException e) {
							hata_var_mý = true;
							ChatRoomApplet.GelenKutusu.append("\nIllegalBlockingModeException");
							System.out.println("IllegalBlockingModeException");
							e.printStackTrace();
						} catch (SocketTimeoutException e) {
							hata_var_mý = true;
							ChatRoomApplet.GelenKutusu.append("\nSocketTimeoutException");
							System.out.println("SocketTimeoutException");
							e.printStackTrace();
						} catch (IOException e) {
							hata_var_mý = true;
							ChatRoomApplet.GelenKutusu.append("\nIOException");
							System.out.println("IOException");
							e.printStackTrace();
						} catch (Exception e) {
							hata_var_mý = true;
							ChatRoomApplet.GelenKutusu.append("\nException");
							System.out.println("Exception");
							e.printStackTrace();
						}
						if (hata_var_mý == false) {
							if (clientSentence != null) {
								ChatRoomApplet.GelenKutusu.append("\n" + clientSentence);
								System.out.println(clientSentence);
								// System.out.println("sendmessage(message_receiver_socket_list,
								// message);");
								clientSentence += "\n";// satir sonu
								sendmessage(message_receiver_socket_list, clientSentence);// Clientten
							} else {
								// System.out.println("clientSentence null");
							}
						}

					}
				}
			}
		}
	}

	/**
	 * @return
	 */
	public static String kullanýcýlarý_guncelle() {
		String kullanýcýlar = "";
		if (Server.getUser_list() != null && Server.getUser_list().size() != 0) {
			for (String kullanýcý : Server.getUser_list()) {
				kullanýcýlar += kullanýcý + "\n";
			}
		}
		return kullanýcýlar;
	}

	private void sendmessage(Vector<Socket> message_receiver_socket_list, String message) {
		// System.out.println("Listeye mesaj gönderiliyor.");
		for (Socket s : message_receiver_socket_list) {
			// System.out.println("create_single_message_writer_thread(s,
			// message);");
			create_single_message_writer_thread(s, message);
		}
	}

	private void create_single_message_writer_thread(Socket socket, String message) {
		OutputStream soketoutputstream = null;
		Thread thread_single_messagewriter = null;
		boolean hata_var_mý = false;
		if (socket != null) {
			if (!socket.isClosed()) {
				try {
					// System.out.println("soketoutputstream =
					// socket.getOutputStream();");
					soketoutputstream = socket.getOutputStream();
				} catch (ConnectException e) {
					hata_var_mý = true;
					ChatRoomApplet.GelenKutusu.append(
							"\nSignals that an error occurred while attempting to connect a socket to a remote address and port. Typically, the connection was refused remotely (e.g., no process is listening on the remote address/port).");
					System.out.println(
							"Signals that an error occurred while attempting to connect a socket to a remote address and port. Typically, the connection was refused remotely (e.g., no process is listening on the remote address/port).");
					e.printStackTrace();// cs null
				} catch (InvalidClassException e) {
					hata_var_mý = true;
					ChatRoomApplet.GelenKutusu.append("\nInvalidClassException");
					System.out.println("InvalidClassException");
					e.printStackTrace();
				} catch (OptionalDataException e) {
					hata_var_mý = true;
					ChatRoomApplet.GelenKutusu.append("\nOptionalDataException");
					System.out.println("OptionalDataException");
					e.printStackTrace();
				} catch (StreamCorruptedException sce) {
					hata_var_mý = true;
					ChatRoomApplet.GelenKutusu.append("\nStreamCorruptedException");
					System.out.println("StreamCorruptedException");
					try {
						socket.close();
					} catch (IOException e1) {
						hata_var_mý = true;
						ChatRoomApplet.GelenKutusu.append("\nIOException");
						System.out.println("IOException");
						e1.printStackTrace();
					}
					sce.printStackTrace();
				} catch (NullPointerException e) {
					hata_var_mý = true;
					ChatRoomApplet.GelenKutusu.append("\nNullPointerException");
					System.out.println("NullPointerException");
					e.printStackTrace();
				} catch (SocketException e) {
					hata_var_mý = true;
					ChatRoomApplet.GelenKutusu.append("\nSocketException");
					System.out.println("SocketException");
					e.printStackTrace();
				} catch (UnknownHostException e) {
					hata_var_mý = true;
					ChatRoomApplet.GelenKutusu.append("\nThe IP address of the host could not be determined.");
					System.out.println("The IP address of the host could not be determined.");
					e.printStackTrace();
				} catch (IllegalBlockingModeException e) {
					hata_var_mý = true;
					ChatRoomApplet.GelenKutusu.append("\nIllegalBlockingModeException");
					System.out.println("IllegalBlockingModeException");
					e.printStackTrace();
				} catch (SocketTimeoutException e) {
					hata_var_mý = true;
					ChatRoomApplet.GelenKutusu.append("\nSocketTimeoutException");
					System.out.println("SocketTimeoutException");
					e.printStackTrace();
				} catch (IOException e) {
					hata_var_mý = true;
					ChatRoomApplet.GelenKutusu.append("\nIOException");
					System.out.println("IOException");
					e.printStackTrace();
				} catch (Exception e) {
					hata_var_mý = true;
					ChatRoomApplet.GelenKutusu.append("\nException");
					System.out.println("Exception");
					e.printStackTrace();
				}
			}
			if (hata_var_mý == false) {
				try {
					thread_single_messagewriter = new Thread(new Singlemessagewriter(soketoutputstream, message));// Serverdan
				} catch (NullPointerException e) {
					hata_var_mý = true;
					ChatRoomApplet.GelenKutusu.append("\nNullPointerException");
					System.out.println("NullPointerException");
					e.printStackTrace();
				} catch (IllegalBlockingModeException e) {
					hata_var_mý = true;
					ChatRoomApplet.GelenKutusu.append("\nIllegalBlockingModeException");
					System.out.println("IllegalBlockingModeException");
					e.printStackTrace();
				} catch (Exception e) {
					hata_var_mý = true;
					ChatRoomApplet.GelenKutusu.append("\nException");
					System.out.println("Exception");
					e.printStackTrace();
				}
			}
			if (hata_var_mý == false) {
				if (thread_single_messagewriter != null) {
					try {
						// System.out.println("thread_single_messagewriter.start();");
						thread_single_messagewriter.start();
						// System.out.println("thread_single_messagewriter.started;");
					} catch (NullPointerException e) {
						hata_var_mý = true;
						ChatRoomApplet.GelenKutusu.append("\nNullPointerException");
						System.out.println("NullPointerException");
						e.printStackTrace();
					} catch (IllegalBlockingModeException e) {
						hata_var_mý = true;
						ChatRoomApplet.GelenKutusu.append("\nIllegalBlockingModeException");
						System.out.println("IllegalBlockingModeException");
						e.printStackTrace();
					} catch (Exception e) {
						hata_var_mý = true;
						ChatRoomApplet.GelenKutusu.append("\nException");
						System.out.println("Exception");
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * @return the soketinputstream
	 */
	public InputStream getSoketinputstream() {
		return soketinputstream;
	}

	/**
	 * @return the message_receiver_socket_list
	 */
	public Vector<Socket> getMessage_receiver_socket_list() {
		return message_receiver_socket_list;
	}

	/**
	 * @param message_receiver_socket_list
	 *            the message_receiver_socket_list to set
	 */
	public void setMessage_receiver_socket_list(Vector<Socket> message_receiver_socket_list) {
		this.message_receiver_socket_list = message_receiver_socket_list;
	}

	/**
	 * @param soketinputstream
	 *            the soketinputstream to set
	 */
	public void setSoketinputstream(InputStream soketinputstream) {
		this.soketinputstream = soketinputstream;
	}

	/**
	 * @return the kullanýcýlar
	 */
	public static String getKullanýcýlar() {
		return kullanýcýlar;
	}

	/**
	 * @param kullanýcýlar
	 *            the kullanýcýlar to set
	 */
	public static void setKullanýcýlar(String kullanýcýlar) {
		Broadcaster.kullanýcýlar = kullanýcýlar;
	}

}
