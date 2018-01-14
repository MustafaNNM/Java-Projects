package client;
/**
 * 
 */

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
	private Boolean hata_var_mý = false;

	public SocketListener(InputStream inputstream) {
		// System.out.println("SocketListener consructor");
		// System.out.println("try_setting_inputstream(inputstream);");
		try_setting_inputstream(inputstream);
	}

	/**
	 * @param inputstream
	 */
	private void try_setting_inputstream(InputStream inputstream) {
		// System.out.println("inputstream != null");
		if (inputstream != null) {
			// System.out.println("this.inputstream = inputstream;");
			this.inputstream = inputstream;
		} else {
			// System.out.println("InputStream null");
		}
	}

	@Override
	public void run() {
		// System.out.println("SocketListener.run çalýþtýrýlýyor");
		// String message = null;
		// System.out.println("soketinputstream != null");
		if (inputstream != null) {
			// System.out.println("InputStreamReader inputstreamreader = new
			// InputStreamReader(soketinputstream);");
			InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
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
							ChatRoomMemberApplet.GelenKutusu.append("\nSignals that an error occurred while attempting"
									+ "\nto connect a socket to a remote address and port."
									+ "\nTypically, the connection was refused remotely"
									+ "\n(e.g., no process is listening on the remote address/port).");
							System.out.println(
									"Signals that an error occurred while attempting to connect a socket to a remote address and port. Typically, the connection was refused remotely (e.g., no process is listening on the remote address/port).");
							e.printStackTrace();// cs null
						} catch (InvalidClassException e) {
							hata_var_mý = true;
							ChatRoomMemberApplet.GelenKutusu.append("\nInvalidClassException");
							System.out.println("InvalidClassException");
							e.printStackTrace();
						} catch (OptionalDataException e) {hata_var_mý = true;
							ChatRoomMemberApplet.GelenKutusu.append("\nOptionalDataException");
							System.out.println("OptionalDataException");
							e.printStackTrace();
						} catch (StreamCorruptedException sce) {hata_var_mý = true;
							ChatRoomMemberApplet.GelenKutusu.append("\nStreamCorruptedException");
							System.out.println("StreamCorruptedException");
							sce.printStackTrace();
						} catch (NullPointerException e) {hata_var_mý = true;
							ChatRoomMemberApplet.GelenKutusu.append("\nNullPointerException");
							System.out.println("NullPointerException");
							e.printStackTrace();
						} catch (SocketException e) {hata_var_mý = true;
							ChatRoomMemberApplet.GelenKutusu.append("\nServer kapandý.");
							System.out.println("SocketException");
							try {
								inFromClient.close();
								inputstreamreader.close();
								inputstream.close();
							} catch (IOException e1) {
								System.out.println("IOException");
								e1.printStackTrace();
							}
							//e.printStackTrace();
						} catch (UnknownHostException e) {hata_var_mý = true;
							ChatRoomMemberApplet.GelenKutusu
									.append("\nThe IP address of the host could not be determined.");
							System.out.println("The IP address of the host could not be determined.");
							e.printStackTrace();
						} catch (IllegalBlockingModeException e) {hata_var_mý = true;
							ChatRoomMemberApplet.GelenKutusu.append("\nIllegalBlockingModeException");
							System.out.println("IllegalBlockingModeException");
							e.printStackTrace();
						} catch (SocketTimeoutException e) {hata_var_mý = true;
							ChatRoomMemberApplet.GelenKutusu.append("\nSocketTimeoutException");
							System.out.println("SocketTimeoutException");
							e.printStackTrace();
						} catch (IOException e) {hata_var_mý = true;
							ChatRoomMemberApplet.GelenKutusu.append("\nIOException");
							System.out.println("IOException");
							e.printStackTrace();
						} catch (Exception e) {hata_var_mý = true;
							ChatRoomMemberApplet.GelenKutusu.append("\nException");
							System.out.println("Exception");
							e.printStackTrace();
						}
						if (clientSentence != null) {
							ChatRoomMemberApplet.GelenKutusu.append("\n" + clientSentence);
							System.out.println("Serverdan gelen mesaj:" + clientSentence);
						} else {
							// ChatRoomMemberApplet.GelenKutusu.append("\nclientSentence
							// null");
							System.out.println("clientSentence null");
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
		// System.out.println("return inputstream;");
		return inputstream;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		// System.out.println("return message;");
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		// System.out.println("this.message = message;");
		this.message = message;
	}


	/**
	 * @return the hata_var_mý
	 */
	public Boolean getHata_var_mý() {
		return hata_var_mý;
	}

	/**
	 * @param hata_var_mý the hata_var_mý to set
	 */
	public void setHata_var_mý(Boolean hata_var_mý) {
		this.hata_var_mý = hata_var_mý;
	}

	/**
	 * @param inputstream
	 *            the inputstream to set
	 */
	public void setInputstream(InputStream inputstream) {
		// System.out.println("this.inputstream = inputstream;");
		this.inputstream = inputstream;
	}
}
