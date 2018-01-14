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
import java.util.Vector;

public class Multimessagewriter implements Runnable {
	private InputStream soketinputstream = null;
	Vector<Socket> message_receiver_socket_list = null;

	public Multimessagewriter(Vector<Socket> message_receiver_socket_list, InputStream soketinputstream) {
		System.out.println("Messageprinter oluþturuluyor");
		this.message_receiver_socket_list = message_receiver_socket_list;
		if (soketinputstream != null) {
			this.setSoketinputstream(soketinputstream);
		} else {
			System.out.println("Messageprinter oluþturulamadi");
		}
	}

	@Override
	public void run() {
		System.out.println("Multimessagewriter.run çalýþtýrýlýyor");
		// String message = null;
		System.out.println("soketinputstream != null");
		if (soketinputstream != null) {
			System.out.println("InputStreamReader inputstreamreader = new InputStreamReader(soketinputstream);");
			InputStreamReader inputstreamreader = new InputStreamReader(soketinputstream);
			System.out.println("inputstreamreader != null");
			if (inputstreamreader != null) {
				System.out.println("BufferedReader inFromClient = new BufferedReader(inputstreamreader);");
				BufferedReader inFromClient = new BufferedReader(inputstreamreader);
				System.out.println("inFromClient != null");
				if (inFromClient != null) {
					// int data = 0;
					// Boolean hata = false;
					String clientSentence = "";
					System.out.println("donguye giriliyor");
					while (true) {
						try {
							System.out.println("clientSentence = inFromClient.readLine();");
							clientSentence = inFromClient.readLine();
							if (clientSentence != null) {
								System.out.println("Clientten gelen mesaj:" + clientSentence);
								System.out.println("sendmessage(message_receiver_socket_list, message);");
								clientSentence+="\n";//satir sonu
								sendmessage(message_receiver_socket_list, clientSentence);// Clientten
							} else {
								System.out.println("clientSentence null");
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
				}
			}
		}
	}

	private void sendmessage(Vector<Socket> message_receiver_socket_list, String message) {
		System.out.println("Listeye mesaj gönderiliyor.");
		for (Socket s : message_receiver_socket_list) {
			//System.out.println("create_single_message_writer_thread(s, message);");
			create_single_message_writer_thread(s, message);
		}
	}

	private void create_single_message_writer_thread(Socket socket, String message) {
		OutputStream soketoutputstream = null;
		Thread thread_single_messagewriter = null;
		if (socket != null) {
			try {
				System.out.println("soketoutputstream = socket.getOutputStream();");
				soketoutputstream = socket.getOutputStream();
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
					socket.close();
				} catch (IOException e1) {
					System.out.println("IOException");
					e1.printStackTrace();
				}
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
			System.out.println(
					"thread_single_messagewriter = new Thread(new Singlemessagewriter(soketoutputstream, message));");
			thread_single_messagewriter = new Thread(new Singlemessagewriter(soketoutputstream, message));// Serverdan

			if (thread_single_messagewriter != null) {
				try {
					System.out.println("thread_single_messagewriter.start();");
					thread_single_messagewriter.start();
					System.out.println("thread_single_messagewriter.started;");
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
		}
	}

	/**
	 * @return the soketinputstream
	 */
	public InputStream getSoketinputstream() {
		return soketinputstream;
	}

	/**
	 * @param soketinputstream
	 *            the soketinputstream to set
	 */
	public void setSoketinputstream(InputStream soketinputstream) {
		this.soketinputstream = soketinputstream;
	}
}
