package com.example;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

    public static void sendTextEmail(String email, String asunto, String contenido){      
        
        Properties properties = App.applicationProperties();        
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication( properties.getProperty("mail.smtp.email"), properties.getProperty("mail.smtp.password"));
            }
        });
        
         try {
            // Crear un objeto MimeMessage
            Message message = new MimeMessage(session);

            // Establecer el remitente
            message.setFrom(new InternetAddress(properties.getProperty("mail.smtp.email")));

            // Establecer el destinatario(s)
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));

            // Establecer el asunto
            message.setSubject(asunto);

            // Establecer el contenido del mensaje
            message.setText(contenido);

            // Enviar el correo electrónico
            Transport.send(message);
        } catch (MessagingException e) {
             System.out.println(e.toString());
        }
    }
}
