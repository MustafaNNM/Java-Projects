package server;

import java.io.IOException;
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
import java.util.Vector;

import gui.server.ChatRoomApplet;

public class Multimessagewriter implements Runnable {
	private Vector<Socket> received_connection_list;
	private static Vector<Thread> thread_list;
	private String message;
	private static Singlemessagewriter singlemessagewriter;

	public Multimessagewriter(Vector<Socket> received_connection_list, String message) {
		if (received_connection_list != null) {
			this.received_connection_list = received_connection_list;
			this.message = message;
		} else {
			ChatRoomApplet.GelenKutusu.append("\nMultimessagewriter oluþturulamadý");
			System.out.println("Multimessagewriter oluþturulamadý");
		}
	}

	@Override
	public void run() {
		@SuppressWarnings("unused")
		boolean hata_var_mý=false;
		thread_list = new Vector<Thread>();
		hata_var_mý=create_single_message_writer_threads();
	}

	public boolean create_single_message_writer_threads() {
		OutputStream soketoutputstream = null;
		boolean hata_var_mý=false;
		if (hata_var_mý == false) {
			for (Socket s : received_connection_list) {
				if (s != null && hata_var_mý == false) {
					try {
						// System.out.println("soketoutputstream =
						// socket.getOutputStream();");
						soketoutputstream = s.getOutputStream();
					} catch (ConnectException e) {
						hata_var_mý = true;
						ChatRoomApplet.GelenKutusu.append("\nSignals that an error occurred while attempting "
								+ "\nto connect a socket to a remote address and port."
								+ "\nTypically, the connection was refused remotely"
								+ "\n(e.g., no process is listening on the remote address/port).");
						System.out.println(
								"Signals that an error occurred while attempting to connect a socket to a remote address and port. Typically, the connection was refused remotely (e.g., no process is listening on the remote address/port).");
						e.printStackTrace();// cs null
					} catch (InvalidClassException e) {
						ChatRoomApplet.GelenKutusu.append("\nInvalidClassException");
						hata_var_mý = true;
						System.out.println("InvalidClassException");
						e.printStackTrace();
					} catch (OptionalDataException e) {
						ChatRoomApplet.GelenKutusu.append("\nOptionalDataException");
						hata_var_mý = true;
						System.out.println("OptionalDataException");
						e.printStackTrace();
					} catch (StreamCorruptedException sce) {
						sce.printStackTrace();
						ChatRoomApplet.GelenKutusu.append("\nStreamCorruptedException");
						hata_var_mý = true;
						System.out.println("StreamCorruptedException");
						try {
							s.close();
						} catch (IOException e1) {
							ChatRoomApplet.GelenKutusu.append("\nIOException");
							hata_var_mý = true;
							System.out.println("IOException");
							e1.printStackTrace();
						}
					} catch (NullPointerException e) {
						ChatRoomApplet.GelenKutusu.append("\nNullPointerException");
						hata_var_mý = true;
						System.out.println("NullPointerException");
						e.printStackTrace();
					} catch (SocketException e) {
						ChatRoomApplet.GelenKutusu.append("\nSocketException");
						hata_var_mý = true;
						System.out.println("SocketException");
						try {
							s.close();
						} catch (IOException e1) {
							ChatRoomApplet.GelenKutusu.append("\nIOException");
							hata_var_mý = true;
							System.out.println("IOException");
							e1.printStackTrace();
						}
						e.printStackTrace();
					} catch (UnknownHostException e) {
						ChatRoomApplet.GelenKutusu.append("\nThe IP address of the host could not be determined.");
						hata_var_mý = true;
						System.out.println("The IP address of the host could not be determined.");
						e.printStackTrace();
					} catch (IllegalBlockingModeException e) {
						ChatRoomApplet.GelenKutusu.append("\nIllegalBlockingModeException");
						hata_var_mý = true;
						System.out.println("IllegalBlockingModeException");
						e.printStackTrace();
					} catch (SocketTimeoutException e) {
						ChatRoomApplet.GelenKutusu.append("\nSocketTimeoutException");
						hata_var_mý = true;
						System.out.println("SocketTimeoutException");
						e.printStackTrace();
					} catch (IOException e) {
						ChatRoomApplet.GelenKutusu.append("\nIOException");
						hata_var_mý = true;
						System.out.println("IOException");
						e.printStackTrace();
					} catch (Exception e) {
						ChatRoomApplet.GelenKutusu.append("\nException");
						hata_var_mý = true;
						System.out.println("Exception");
						e.printStackTrace();
					}
					if (hata_var_mý == false) {
						try {
							singlemessagewriter = new Singlemessagewriter(soketoutputstream, message);
						} catch (NullPointerException e) {
							ChatRoomApplet.GelenKutusu.append("\nNullPointerException");
							hata_var_mý = true;
							System.out.println("NullPointerException");
							e.printStackTrace();
						} catch (IllegalBlockingModeException e) {
							ChatRoomApplet.GelenKutusu.append("\nIllegalBlockingModeException");
							hata_var_mý = true;
							System.out.println("IllegalBlockingModeException");
							e.printStackTrace();
						} catch (Exception e) {
							ChatRoomApplet.GelenKutusu.append("\nException");
							hata_var_mý = true;
							System.out.println("Exception");
							e.printStackTrace();
						}
						if (hata_var_mý == false) {
							if (singlemessagewriter != null) {
								try {

									// System.out.println(
									// "thread_list.add(new Thread(new
									// Singlemessagewriter(soketoutputstream,
									// message)));"
									// );
									thread_list.add(new Thread(singlemessagewriter));
								} catch (NullPointerException e) {
									hata_var_mý = true;
									ChatRoomApplet.GelenKutusu.append("\nBurada hatavar mý yok mu ?");
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
								if (hata_var_mý == false) {
									try {
										// System.out.println("thread_list.lastElement().start();");
										thread_list.lastElement().start();
									} catch (NullPointerException e) {
										hata_var_mý=true;
										ChatRoomApplet.GelenKutusu.append("\nNullPointerException");
										System.out.println("NullPointerException");
										e.printStackTrace();
									} // catch bitiþi
									catch (IllegalBlockingModeException e) {
										hata_var_mý=true;
										ChatRoomApplet.GelenKutusu.append("\nIllegalBlockingModeException");
										System.out.println("IllegalBlockingModeException");
										e.printStackTrace();
									} // catch bitiþi
									catch (Exception e) {
										hata_var_mý=true;
										ChatRoomApplet.GelenKutusu
												.append("\nThread listteki son eleman baþlatýlamadý!");
										System.out.println("Thread listteki son eleman baþlatýlamadý!");
										e.printStackTrace();
									} // catch bitiþi
								}
							} else {
								hata_var_mý = true;
								// System.out.println("NullPointerException");
								//exit
							}
						} else {
							// exit
						}
					} else {
						// exit
					}
				} else {
					System.out.println("Thread listteki son eleman baþlatýlamadý!");
				}
			}
		}
		return hata_var_mý;
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
		this.received_connection_list = received_connection_list;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the thread_list
	 */
	public static Vector<Thread> getThread_list() {
		return thread_list;
	}

	/**
	 * @return the singlemessagewriter
	 */
	public static Singlemessagewriter getSinglemessagewriter() {
		return singlemessagewriter;
	}

	/**
	 * @param singlemessagewriter
	 *            the singlemessagewriter to set
	 */
	public static void setSinglemessagewriter(Singlemessagewriter singlemessagewriter) {
		Multimessagewriter.singlemessagewriter = singlemessagewriter;
	}


	/**
	 * @param thread_list
	 *            the thread_list to set
	 */
	public static void setThread_list(Vector<Thread> thread_list) {
		Multimessagewriter.thread_list = thread_list;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
