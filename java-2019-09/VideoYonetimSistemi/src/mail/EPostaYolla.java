package mail;

import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EPostaYolla {

	public static void main(String[] args) {
		try {
			// e-postayý göndereceðiniz adres
			String from = "mehmet.akif@mcf.com.tr";/*mehmetakifilyasogullari@gmail.com*/
			// hesabýnýzýn parolasý
			String pass = "Antidarbe.35";/*pragmadm*/
			// e-postanýn gönderileceði adresler
			String[] to = { "mehmetakifilyasogullari@gmail.com" };
			// host
			String host = "smtp.office365.com";/*smtp.gmail.com*/

			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.password", pass);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props, null);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			InternetAddress[] toAddress = new InternetAddress[to.length];
			for (int i = 0; i < to.length; i++) {
				toAddress[i] = new InternetAddress(to[i]);
			}

			for (int i = 0; i < toAddress.length; i++) {
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}
			// baþlýk
			message.setSubject("Hack");
			// içerik
			message.setText("Deneme maili");
			Transport transport = session.getTransport("smtp");
			try {
			transport.connect(host, from, pass);
			} catch (AuthenticationFailedException e) {
				e.printStackTrace();
			} catch (Exception e) {
					e.printStackTrace();
			}
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}