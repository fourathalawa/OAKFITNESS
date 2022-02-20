/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.projectoak.javamail;

import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Session;

/**
 *
 * @author user
 */
public class javaMailUtil {

    public static void sendMail(String recepient) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smpt.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put(" mail.smtp.port", "587");

 String myAccountEmail = "habibfiras.hadroug@esprit.tn";
String password = "xx";

        Session session = Session.getInstance(properties, new Authenticator() {
            

        });
    }
}
