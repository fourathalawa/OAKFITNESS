package com.tutorialspoint;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendInlineImagesInEmail {

    public static void main(String[] args) {
        String to = "oakfitness.noreply@gmail.com";
        String from = "oakfitness.noreply@gmail.com";
        String password = "OakAdmin9238@yA8(";
        String host = "smtp.gmail.com";
        String port = "587";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", port);

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {

            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("suppression de votre commentaire");

            // This mail has 2 part, the BODY and the embedded image
            MimeMultipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<H2>suppression de votre commentaire</H2><br>l'équipe Oak fitness vous informe que votre commentaire a été retiré du forum car nous avons découvert qu'il était contraire à notre politique</br><br>pour cette raison un de nos administrateurs a supprimé votre commentaire</br><br>vous pouvez lire les règles de notre forum dans la pièce jointe ci-dessous</br><br>si vous pensez qu'il s'agit d'une erreur, veuillez nous envoyer un e-mail à cette adresse</br> <br>Equipe du oak fitness</br>"
                    + "<img src=\"cid:image\">";
            messageBodyPart.setContent(htmlText, "text/html");
            // add it
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = "C:/Users/user/Pictures/oak.pdf";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
           // multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
          //  messageBodyPart = new MimeBodyPart();
            String filename2 = "C:/Users/user/Pictures/oak.png";
            DataSource source2 = new FileDataSource(filename2);
            messageBodyPart.setDataHandler(new DataHandler(source2));
            messageBodyPart.setHeader("Content-ID", "<image>");

//         // second part (the image)
//         messageBodyPart = new MimeBodyPart();
//         DataSource fds = new FileDataSource(
//            "C:/Users/user/Pictures/oak.png");
//
//         messageBodyPart.setDataHandler(new DataHandler(fds));
//         messageBodyPart.setHeader("Content-ID", "<image>");
            // add image to the multipart
            multipart.addBodyPart(messageBodyPart);

            // put everything together
            message.setContent(multipart);
            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
