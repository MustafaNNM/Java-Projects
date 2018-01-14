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
	private Boolean hata_var_m� = false;
	private String message = null;

	public SocketWriter(OutputStream outputStream) {
		// System.out.println("SocketWriter olu�turuluyor");
		hata_var_m� = try_setting_outputstream(outputStream);
	}

	/**
	 * @param outputStream
	 * @return
	 */
	private Boolean try_setting_outputstream(OutputStream outputStream) {
		Boolean hata_var_m� = false;
		// System.out.println("outputStream != null");
		if (hata_var_m� == false) {
			if (outputStream != null) {
				// System.out.println("outputstream = outputStream;");
				outputstream = outputStream;
			} else {
				hata_var_m� = true;
				// System.out.println("OutputStream olu�turulamad�");
			}
		}
		return hata_var_m�;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// System.out.println("outputStream �al��t�r�l�yor");
		// System.out.println("durdurulana_kadar_s�rekli_mesaj_g�nder(hata_var_m�);");
		hata_var_m� = durdurulana_kadar_s�rekli_mesaj_g�nder();

	}

	/**
	 * @param hata_var_m�
	 * @return
	 * @throws HeadlessException
	 */
	private Boolean durdurulana_kadar_s�rekli_mesaj_g�nder() {
		// System.out.println("hata_var_m� == false");
		try {
			while (hata_var_m� == false) {
				// System.out.println("line =
				// JOptionPane.showInputDialog(\"Servera mesaj g�nder\");");
				message = JOptionPane.showInputDialog("Servera g�ndermek istedi�iniz mesaj� giriniz");
				message += "\n";// sonra kaldir
				// System.out.println("try_sending_message_to_server();");
				hata_var_m� = try_sending_message_to_server();
			}
		} catch (HeadlessException e) {
			hata_var_m� = true;
			e.printStackTrace();
		}
		return hata_var_m�;
	}

	/**
	 * @return
	 * 
	 */
	private Boolean try_sending_message_to_server() {
		// System.out.println("if (message != null) {");
		if (message != null) {
			// System.out.println("System.out.println(\"Servera g�nderilen
			// mesaj:\" + line);");
			System.out.println("Servera g�nderilen mesaj:" + message);
			// System.out.println("send_message_to_server(message);");
			hata_var_m� = send_message_to_server(message);
			message = null;
		} else {
			// System.out.println("line null");
		}
		return hata_var_m�;
	}

	/**
	 * @param line
	 * @return
	 */
	private Boolean send_message_to_server(String line) {
		Boolean hata_var_m� = false;
		if (hata_var_m� == false) {
			try {
				// System.out.println("s.write(line.getBytes());");
				outputstream.write(line.getBytes());
			} catch (IOException e) {
				hata_var_m� = true;
				System.out.println("IOException");
				e.printStackTrace();
			}
		}
		return hata_var_m�;
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
	 * @return the hata_var_m�
	 */
	public Boolean getHata_var_m�() {
		return hata_var_m�;
	}

	/**
	 * @param hata_var_m�
	 *            the hata_var_m� to set
	 */
	public void setHata_var_m�(Boolean hata_var_m�) {
		this.hata_var_m� = hata_var_m�;
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
