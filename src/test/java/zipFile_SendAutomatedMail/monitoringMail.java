package zipFile_SendAutomatedMail;




import java.util.Properties;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.Authenticator;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;



public class monitoringMail
{
	//public static void sendMail(String mailServer, String from,String username, String password,String port, String[] to, String subject, String messageBody, String attachmentPath, String attachmentName) throws MessagingException, AddressException
	public void sendEMail(String mailServer, String from, String[] to, String subject, String messageBody, String attachmentPath, String attachmentName) throws MessagingException, AddressException
	{
		boolean debug = false;

        // Set mail properties
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", mailServer);
        props.put("mail.smtp.port", "587"); // Typically 587 for TLS
        props.put("mail.smtp.ssl.trust", mailServer);

        // Create session with authentication
        Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getInstance(props, auth);
        session.setDebug(debug);

        try {
            // Create message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            InternetAddress[] addressTo = new InternetAddress[to.length];
            for (int i = 0; i < to.length; i++) {
                addressTo[i] = new InternetAddress(to[i]);
            }
            message.setRecipients(Message.RecipientType.TO, addressTo);
            message.setSubject(subject);

            // Email body
            BodyPart body = new MimeBodyPart();
            body.setContent(messageBody, "text/html");

            // Email attachment
            MimeBodyPart attachment = new MimeBodyPart();
            DataSource source = new FileDataSource(attachmentPath);
            attachment.setDataHandler(new DataHandler(source));
            attachment.setFileName(attachmentName);

            // Combine body and attachment
            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(body);
            multipart.addBodyPart(attachment);
            message.setContent(multipart);

            // Send email
            Transport.send(message);
            System.out.println("Email successfully sent to all users.");

        } catch (MessagingException e) {
            System.err.println("Error while sending email: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Authenticator class for SMTP
    private class SMTPAuthenticator extends Authenticator {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            String username = TestConfig.from;
            String password = TestConfig.password;
            return new PasswordAuthentication(username, password);
        }
    }
}