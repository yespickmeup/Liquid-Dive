/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.send_mail;

/**
 *
 * @author Maytopacka
 */
import javax.mail.*;
import javax.mail.internet.*;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author Mlungisi
 *
 */
public class MailClient {

    public static void sendMail(String senderEmail, String recipientEmail, String subject, String message,String path) throws MessagingException, UnsupportedEncodingException {

        // SSL // I USED THIS METHOD            
        Properties propsSSL = new Properties();

        // EVEN IF YOU SKIP THESE TWO PROP IT WOULD WORK
        propsSSL.put("mail.transport.protocol", "smtps");
        propsSSL.put("mail.smtps.host", "smtp.gmail.com");

        // THIS IS THE MOST IMPORTANT PROP --> "mail.smtps.auth"
        propsSSL.put("mail.smtps.auth", "true");

        Session sessionSSL = Session.getInstance(propsSSL);
        sessionSSL.setDebug(true);


        Message messageSSL = new MimeMessage(sessionSSL);
        messageSSL.setFrom(new InternetAddress("dodong.ronald@gmail.com", subject));
        messageSSL.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail)); // real recipient
        messageSSL.setSubject(message);

        Multipart multipart = new MimeMultipart();
        MimeBodyPart messageBodyPart =
                new MimeBodyPart();
        messageBodyPart.setText("Hi");
        multipart.addBodyPart(messageBodyPart);

        messageBodyPart = new MimeBodyPart();
        DataSource source =
                new FileDataSource(path);
        messageBodyPart.setDataHandler(
                new DataHandler(source));
        messageBodyPart.setFileName(path);
        multipart.addBodyPart(messageBodyPart);


//        messageSSL.setText("This is test email sent to Your account using SSL.");
        messageSSL.setContent(multipart);

        // create the message part 


        Transport transportSSL = sessionSSL.getTransport();
        // EVEN IF YOU SKIP PORT NUMBER , IT WOULD WORK
        transportSSL.connect("smtp.gmail.com", 465, "dodong.ronald@gmail.com", "soloister123"); // account used
        transportSSL.sendMessage(messageSSL, messageSSL.getAllRecipients());
        transportSSL.close();

        System.out.println("SSL done.");
    }

    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
        System.out.println("Hello World!");
        sendMail(null, null, null, null,"");
    }
}