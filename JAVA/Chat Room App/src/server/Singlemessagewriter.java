/**
 * 
 */
package server;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author MehmetAkif-PC
 *
 */
public class Singlemessagewriter implements Runnable {
	private String message = null;
	private OutputStream os;

	public Singlemessagewriter(OutputStream os, String message) {
		System.out.println("Singlemessagewriter oluþturuluyor");
		if (os != null) {
			this.os = os;
			this.message = message;
		}else {
			System.out.println("Singlemessagewriter oluþturulamadý");
		}
	}

	@Override
	public void run() {
		System.out.println("Singlemessagewriter çalýþtýrýlýyor");
		System.out.println("writemessagestooutputStream();");
		writemessagestooutputStream();
	}

	/**
	 * @param bufferedreader
	 */
	// Serverdan Clienta mesaj gönderiliyor
	private void writemessagestooutputStream() {
		System.out.println("writemessagestooutputStream çalýþtýrýlýyor");
		if (message != null) {
			try {
				System.out.println("os.write(message.getBytes());");
				os.write(message.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Message null");
		}
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the os
	 */
	public OutputStream getOs() {
		return os;
	}

	/**
	 * @param os the os to set
	 */
	public void setOs(OutputStream os) {
		this.os = os;
	}
}