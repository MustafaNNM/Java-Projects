/**
 * 
 */
package client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;


/**
 * @author MehmetAkif-PC
 *
 */
public class Singlemessagewriter implements Runnable {
	private OutputStream outputStream;
	String message=null;
	public Singlemessagewriter(OutputStream outputStream, String message) {
		System.out.println("Singlemessagewriter olu�turuluyor");
		if (outputStream != null) {
			this.outputStream = outputStream;
			this.message=message;
		} else {
			System.out.println("Singlemessagewriter olu�turulamadi");
		}
		
	}

	@Override
	public void run() {
		System.out.println("Singlemessagewriter �al��t�r�l�yor");
		writemessagestooutputStream();
	}
	/**
	 * @param bufferedreader
	 */
//Serverdan Clienta mesaj g�nderiliyor
	private void writemessagestooutputStream() {
		System.out.println("writemessagestooutputStream �al��t�r�l�yor");
		
			if (message != null) {
				if (outputStream != null) {
					try {
						outputStream.write(message.getBytes());
					} catch (NullPointerException e) {
						System.out.println("NullPointerException");
						e.printStackTrace();
					} catch (SocketException e) {
						System.out.println("SocketException");
						e.printStackTrace();
					} catch (IOException e) {
						System.out.println("IOException");
						e.printStackTrace();
					} catch (Exception e) {
						System.out.println("Exception");
						e.printStackTrace();
					}
					
				} else {
					System.out.println("outputStream nullxxx");
				}
				System.out.println("<" + "Serverdan clienta g�nderilen mesaj" + ">:" + message);
				message = null;
			} else {
				System.out.println("message null");
			}
	}

	/**
	 * @return the outputStream
	 */
	public OutputStream getOutputStream() {
		return outputStream;
	}

	/**
	 * @param outputStream
	 *            the outputStream to set
	 */
	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}
}
