package client;
/**
 * 
 */


import java.awt.HeadlessException;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JOptionPane;

/**
 * @author MehmetAkif-PC
 *
 */
public class SocketWriter implements Runnable {
	private OutputStream outputstream = null;
	private Boolean hata_var_mý = false;
	private String message = null;

	public SocketWriter(OutputStream outputStream) {
		//System.out.println("SocketWriter oluþturuluyor");
		try_setting_outputstream(outputStream);
	}

	/**
	 * @param outputStream
	 */
	private void try_setting_outputstream(OutputStream outputStream) {
		//System.out.println("outputStream != null");
		if (outputStream != null) {
			//System.out.println("outputstream = outputStream;");
			outputstream = outputStream;
		} else {
			//System.out.println("OutputStream oluþturulamadý");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		//System.out.println("outputStream çalýþtýrýlýyor");
		//System.out.println("durdurulana_kadar_sürekli_mesaj_gönder(hata_var_mý);");
		durdurulana_kadar_sürekli_mesaj_gönder(hata_var_mý);

	}

	/**
	 * @param hata_var_mý
	 * @throws HeadlessException
	 */
	private void durdurulana_kadar_sürekli_mesaj_gönder(Boolean hata_var_mý) throws HeadlessException {
		//System.out.println("hata_var_mý == false");
		while (hata_var_mý == false) {
			//System.out.println("line = JOptionPane.showInputDialog(\"Servera mesaj gönder\");");
			message = JOptionPane.showInputDialog("Servera mesaj gönder");
			message+="\n";//sonra kaldir
			System.out.println("try_sending_message_to_server();");
			try_sending_message_to_server();
		}
	}

	/**
	 * 
	 */
	private void try_sending_message_to_server() {
		System.out.println("if (message != null) {");
		if (message != null) {
			System.out.println("System.out.println(\"Servera gönderilen mesaj:\" + line);");
			System.out.println("Servera gönderilen mesaj:" + message);
			System.out.println("send_message_to_server(message);");
			send_message_to_server(message);
			message = null;
		} else {
			System.out.println("line null");
		}
	}

	/**
	 * @param line
	 */
	private void send_message_to_server(String line) {
		try {
			System.out.println("s.write(line.getBytes());");
			outputstream.write(line.getBytes());
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}
	}

	/**
	 * @return the outputstream
	 */
	public OutputStream getOutputstream() {
		return outputstream;
	}

	/**
	 * @param outputstream
	 *            the outputstream to set
	 */
	public void setOutputstream(OutputStream outputstream) {
		this.outputstream = outputstream;
	}

	/**
	 * @return the hata_var_mý
	 */
	public Boolean getHata_var_mý() {
		return hata_var_mý;
	}

	/**
	 * @param hata_var_mý
	 *            the hata_var_mý to set
	 */
	public void setHata_var_mý(Boolean hata_var_mý) {
		this.hata_var_mý = hata_var_mý;
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
	 * @param line
	 *            the line to set
	 */
	public void setLine(String line) {
		this.message = line;
	}

}
