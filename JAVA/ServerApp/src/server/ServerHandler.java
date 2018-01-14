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

import test.server.ChatRoomApplet;

public class ServerHandler implements Runnable {
	private Vector<Socket> message_receiver_socket_list = null;
	private InputStream soketinputstream = null;
	private Socket socket_to_listen = null;
	private String line = null;
	private Thread thread_multi_messagewriter = null;
	private Vector<String> user_list;

	public ServerHandler(Vector<Socket> message_receiver_socket_list, Socket socket_to_listen,
			Vector<String> user_list) {
		// System.out.println("Server Handler oluþturuluyor");
		if (message_receiver_socket_list != null) {
			this.message_receiver_socket_list = message_receiver_socket_list;
			if (socket_to_listen != null) {
				this.socket_to_listen = socket_to_listen;
				if (user_list!=null) {
					this.user_list = user_list;
				}
			}
			// multimessageprinter kullaanýlabilinir
		}
	}

	public void run() {
		// System.out.println("Server Handler çalýþtýrýlýyor");
		boolean hata_var_mý = create_multi_message_writer_thread();
		if (hata_var_mý == false) {
			// continue;
		} else {
			// exit;
		}
	}

	/**
	 * @param socket
	 * @return
	 */
	private boolean create_multi_message_writer_thread() {
		// System.out.println("create_multi_message_writer_thread");
		boolean hata_var_mý = false;
		if (hata_var_mý == false) {
			if (socket_to_listen != null) {
				// System.out.println("try_setting_soket_input_stream();");
				hata_var_mý = try_setting_soket_input_stream();
				if (hata_var_mý == false) {
					if (soketinputstream != null) {
						// System.out.println("create_thread_multi_messagewriter();");
						hata_var_mý = create_thread_multi_messagewriter();
						if (hata_var_mý == false) {
							if (thread_multi_messagewriter != null) {
								// System.out.println("start_thread_multi_message_writer();");
								hata_var_mý = start_thread_multi_message_writer();
							} else {
								hata_var_mý = true;
								ChatRoomApplet.GelenKutusu.append("\nthread_multi_messagewriter baþlatýlamadý");
								System.out.println("thread_multi_messagewriter baþlatýlamadý");
								// exit
							}
						} else {
							// exit
						}
					} else {
						hata_var_mý = true;
						ChatRoomApplet.GelenKutusu.append("\nthread_multi_messagewriter oluþturulamadý");
						System.out.println("thread_multi_messagewriter oluþturulamadý");
						// exit
					}
				}
			} else {
				hata_var_mý = true;
				ChatRoomApplet.GelenKutusu.append("\nsocket_to_listen ayarlanamadý");
				System.out.println("socket_to_listen ayarlanamadý");
				// exit
			}
		}
		return hata_var_mý;
	}

	/**
	 * 
	 */
	private boolean start_thread_multi_message_writer() {
		boolean hata_var_mý = false;
		if (hata_var_mý == false) {
			try {
				// System.out.println("thread_messageprinter.start();");
				thread_multi_messagewriter.start();
				// System.out.println("thread_messageprinter.started");
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
			return hata_var_mý;
		} else {
			// exit
			return hata_var_mý;
		}

	}

	/**
	 * @return
	 * 
	 */
	private boolean create_thread_multi_messagewriter() {
		boolean hata_var_mý = false;
		if (hata_var_mý == false) {
			try {
				/*
				 * System.out.println(
				 * "thread_messagewriter = new Thread(new Multimessagewriter(message_receiver_socket_list,soketinputstream));"
				 * );
				 */thread_multi_messagewriter = new Thread(
						new Broadcaster(message_receiver_socket_list, soketinputstream));
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
			return hata_var_mý;
		} else {
			return hata_var_mý;
		}
	}

	/**
	 * @return
	 * 
	 */
	private boolean try_setting_soket_input_stream() {
		boolean hata_var_mý = false;
		if (hata_var_mý == false) {
			try {
				// System.out.println("soketinputstream =
				// socket.getInputStream();");
				soketinputstream = socket_to_listen.getInputStream();
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
				// System.out.println("close_socket_to_listen();");
				close_socket_to_listen();
			} catch (NullPointerException e) {
				hata_var_mý = true;
				ChatRoomApplet.GelenKutusu.append("\nNullPointerException");
				System.out.println("NullPointerException");
				e.printStackTrace();
			} catch (BindException e) {
				hata_var_mý = true;
				ChatRoomApplet.GelenKutusu.append("\nAddress already in use: JVM_Bind.");
				System.out.println("Address already in use: JVM_Bind.");
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
			return hata_var_mý;
		} else {
			return hata_var_mý;
		}

	}

	/**
	 * 
	 */
	private void close_socket_to_listen() {
		boolean hata_var_mý = false;
		if (hata_var_mý == false) {
			try {
				// System.out.println("socket.close();");
				socket_to_listen.close();
			} catch (IOException e1) {
				hata_var_mý = true;
				ChatRoomApplet.GelenKutusu.append("\nIOException");
				System.out.println("IOException");
				e1.printStackTrace();
			} catch (Exception e1) {
				hata_var_mý = true;
				ChatRoomApplet.GelenKutusu.append("\nException");
				System.out.println("Exception");
				e1.printStackTrace();
			}
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

	/**
	 * @return the user_list
	 */
	public Vector<String> getUser_list() {
		return user_list;
	}

	/**
	 * @param user_list
	 *            the user_list to set
	 */
	public void setUser_list(Vector<String> user_list) {
		this.user_list = user_list;
	}

}
