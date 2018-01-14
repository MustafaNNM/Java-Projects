/**
 * 
 */
package server;

import java.io.IOException;
import java.io.OutputStream;

import gui.server.ChatRoomApplet;

/**
 * @author MehmetAkif-PC
 *
 */
public class Singlemessagewriter implements Runnable {
	private String message = null;
	private OutputStream os;

	public Singlemessagewriter(OutputStream os, String message) {
		// System.out.println("Singlemessagewriter oluþturuluyor");
		if (os != null) {
			this.os = os;
			this.message = message;
		} else {
			ChatRoomApplet.GelenKutusu.append("\nSinglemessagewriter oluþturulamadý");
			System.out.println("Singlemessagewriter oluþturulamadý");
		}
	}

	@Override
	public void run() {
		// System.out.println("Singlemessagewriter çalýþtýrýlýyor");
		// System.out.println("writemessagestooutputStream();");
		writemessagestooutputStream();
	}

	/**
	 * @param bufferedreader
	 */
	// Serverdan Clienta mesaj gönderiliyor
	private void writemessagestooutputStream() {
		// System.out.println("writemessagestooutputStream çalýþtýrýlýyor");
		boolean hata_var_mý = false;
		if (hata_var_mý == false) {
			if (message != null) {
				try {
					// System.out.println("os.write(message.getBytes());");
					os.write(message.getBytes());
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
			} else {
				ChatRoomApplet.GelenKutusu.append("\nMessage null");
				System.out.println("Message null");
			}
		} else {
			// exit
		}
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
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
	 * @param os
	 *            the os to set
	 */
	public void setOs(OutputStream os) {
		this.os = os;
	}
}