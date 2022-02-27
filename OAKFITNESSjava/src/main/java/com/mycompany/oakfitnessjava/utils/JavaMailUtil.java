/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oakfitnessjava.utils;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Heni Nechi
 */
public class JavaMailUtil {

    public static void sendMail(String recepients, String Subject, String Text) throws MessagingException {
        System.out.println("Preparation d'email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        String MyAccount = "heni.m.nechi@gmail.com";
        String password = "qoazcgmxyknlhvuz";

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MyAccount, password);
            }

        });
        Message message = prepareMessage(session, MyAccount, recepients, Subject, Text);
        Transport.send(message);
        System.out.println("Message envoyé avec success");
    }

    private static Message prepareMessage(Session session, String MyAccount, String recepients, String Subject, String Text) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(MyAccount));
            String[] recipientList = recepients.split(",");
            InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
            int counter = 0;
            for (String recipient : recipientList) {
                recipientAddress[counter] = new InternetAddress(recipient.trim());
                counter++;
            }
            message.setRecipients(Message.RecipientType.TO, recipientAddress);
            message.setSubject(Subject);
            message.setText(Text);
            return message;
        } catch (Exception ex) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
