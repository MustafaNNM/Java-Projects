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
	private Boolean hata_var_mı = false;
	private String message = null;

	public SocketWriter(OutputStream outputStream) {
		// System.out.println("SocketWriter oluşturuluyor");
		hata_var_mı = try_setting_outputstream(outputStream);
	}

	/**
	 * @param outputStream
	 * @return
	 */
	private Boolean try_setting_outputstream(OutputStream outputStream) {
		Boolean hata_var_mı = false;
		// System.out.println("outputStream != null");
		if (hata_var_mı == false) {
			if (outputStream != null) {
				// System.out.println("outputstream = outputStream;");
				outputstream = outputStream;
			} else {
				hata_var_mı = true;
				// System.out.println("OutputStream oluşturulamadı");
			}
		}
		return hata_var_mı;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// System.out.println("outputStream çalıştırılıyor");
		// System.out.println("durdurulana_kadar_sürekli_mesaj_gönder(hata_var_mı);");
		hata_var_mı = durdurulana_kadar_sürekli_mesaj_gönder();

	}

	/**
	 * @param hata_var_mı
	 * @return
	 * @throws HeadlessException
	 */
	private Boolean durdurulana_kadar_sürekli_mesaj_gönder() {
		// System.out.println("hata_var_mı == false");
		try {
			while (hata_var_mı == false) {
				// System.out.println("line =
				// JOptionPane.showInputDialog(\"Servera mesaj gönder\");");
				message = JOptionPane.showInputDialog("Servera göndermek istediğiniz mesajı giriniz");
				message += "\n";// sonra kaldir
				// System.out.println("try_sending_message_to_server();");
				hata_var_mı = try_sending_message_to_server();
			}
		} catch (HeadlessException e) {
			hata_var_mı = true;
			e.printStackTrace();
		}
		return hata_var_mı;
	}

	/**
	 * @return
	 * 
	 */
	private Boolean try_sending_message_to_server() {
		// System.out.println("if (message != null) {");
		if (message != null) {
			// System.out.println("System.out.println(\"Servera gönderilen
			// mesaj:\" + line);");
			System.out.println("Servera gönderilen mesaj:" + message);
			// System.out.println("send_message_to_server(message);");
			hata_var_mı = send_message_to_server(message);
			message = null;
		} else {
			// System.out.println("line null");
		}
		return hata_var_mı;
	}

	/**
	 * @param line
	 * @return
	 */
	private Boolean send_message_to_server(String line) {
		Boolean hata_var_mı = false;
		if (hata_var_mı == false) {
			try {
				// System.out.println("s.write(line.getBytes());");
				outputstream.write(line.getBytes());
			} catch (IOException e) {
				hata_var_mı = true;
				System.out.println("IOException");
				e.printStackTrace();
			}
		}
		return hata_var_mı;
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
	 * @return the hata_var_mı
	 */
	public Boolean getHata_var_mı() {
		return hata_var_mı;
	}

	/**
	 * @param hata_var_mı
	 *            the hata_var_mı to set
	 */
	public void setHata_var_mı(Boolean hata_var_mı) {
		this.hata_var_mı = hata_var_mı;
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
