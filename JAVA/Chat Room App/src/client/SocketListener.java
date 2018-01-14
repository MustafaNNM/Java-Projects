/**
 * 
 */
package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InvalidClassException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.channels.IllegalBlockingModeException;

/**
 * @author MehmetAkif-PC
 *
 */
public class SocketListener implements Runnable {
	private InputStream inputstream;
	private String message = null;
	private int data = 0;
	private Boolean hata = false;
	
	public SocketListener(InputStream inputstream) {
		System.out.println("SocketListener consructor");
		System.out.println("try_setting_inputstream(inputstream);");
		try_setting_inputstream(inputstream);
	}

	/**
	 * @param inputstream
	 */
	private void try_setting_inputstream(InputStream inputstream) {
		System.out.println("inputstream != null");
		if (inputstream != null) {
			System.out.println("this.inputstream = inputstream;");
			this.inputstream = inputstream;
		}else {
			System.out.println("InputStream null");		
		}
	}

	@Override
	public void run() {
		System.out.println("SocketListener.run çalýþtýrýlýyor");
		// String message = null;
		System.out.println("soketinputstream != null");
		if (inputstream != null) {
			System.out.println("InputStreamReader inputstreamreader = new InputStreamReader(soketinputstream);");
			InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
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
								System.out.println("Serverdan gelen mesaj:" + clientSentence);
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

	/**
	 * @return the inputstream
	 */
	public InputStream getInputstream() {
		System.out.println("return inputstream;");
		return inputstream;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		System.out.println("return message;");
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		System.out.println("this.message = message;");
		this.message = message;
	}

	/**
	 * @return the data
	 */
	public int getData() {
		System.out.println("return data;");
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		System.out.println("this.data = data;");
		this.data = data;
	}

	/**
	 * @return the hata
	 */
	public Boolean getHata() {
		System.out.println("return hata;");
		return hata;
	}

	/**
	 * @param hata the hata to set
	 */
	public void setHata(Boolean hata) {
		System.out.println("this.hata = hata;");
		this.hata = hata;
	}

	/**
	 * @param inputstream the inputstream to set
	 */
	public void setInputstream(InputStream inputstream) {
		System.out.println("this.inputstream = inputstream;");
		this.inputstream = inputstream;
	}

}
