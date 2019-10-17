package mail;

import java.io.InputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.AuthenticationFailedException;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.io.IOUtils;

class SimpleMail2 {
    public static void main(String[] args) throws Exception{

        System.out.println("Sending mail...");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session mailSession = Session.getDefaultInstance(props,
        new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("mehmetakifilyasogullari@gmail.com","pragmadm");
            }
        });
        Message message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("mehmetakifilyasogullari@gmail.com"));
        message.setSubject("HTML  mail with images");
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("mehmet.akif@mcf.com.tr"));
        message.setText("Dear Mail Crawler," + "\n\n No spam to my email, please!");

        MimeMultipart multipart = new MimeMultipart("related");
        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlText = "<H1>Raghava chary</H1>" + "<img src=\"cid:image\">";
        messageBodyPart.setContent(htmlText, "text/html");
        multipart.addBodyPart(messageBodyPart);
        try {
            messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource("D:\\MCF Akýllý Güv. Teknolojileri A.Þ\\videomanagementsystem - Documents\\eclipse-photon-workspace\\JFXOpenCVJetty\\img\\mcf-logo.png");
            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID","<image>");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Done");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}