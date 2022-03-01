//package com.esprit.projectoak.javamail;
//
//package com.esprit.projectoak.javamail;
//
//import java.util.Properties;
//import javax.mail.Authenticator;
//import javax.mail.Message.RecipientType;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
// 
// 
////smtp.gmail.com
////port 587
// 
///*
// * This sample will help you send email using the Java Mail API using GMAIL.
// * 
// * First you need to download these jar files and add the two jar file (activation.jar and mail.jar) in your project library
// * https://static.javatpoint.com/src/mail/mailactivation.zip
// * 
// * You must set the 'Less secure app access' settings in gmail account to ON.(set these on the sender gmail)
// * 
// * These are tested and working 10:35PM 7/22/2019 UTC
// * 
// * */
// 
//public class javaMailUtil {
// 
//    public static void main(String[] args) {
//        
//        String to = "**********@gmail.com";
//        String from = "***********@gmail.com";
//        String password = "**********";
//        String host = "smtp.gmail.com";
//        String port = "587";
//        Properties properties = System.getProperties();
//        properties.setProperty("mail.smtp.auth", "true");
//        properties.setProperty("mail.smtp.host", host);
//        properties.setProperty("mail.smtp.starttls.enable", "true");
//        properties.setProperty("mail.smtp.port", port);
//        
//        Session session = Session.getDefaultInstance(properties,new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(from,password);
//            }
//        });
//        
//        try {
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from));
//            message.addRecipient(RecipientType.TO, new InternetAddress(to));
//            message.setSubject("Java Mail Subject Here");
//            message.setText("Hello, this is an email test from java mail api client");
//            
//            Transport.send(message);
//            System.out.println("Message sent successfully!");
//            
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
// 
//    }
//    
// 
//}