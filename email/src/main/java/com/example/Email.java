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
    
    private static final String host = "smtp.gmail.com"; // Reemplaza con tu servidor SMTP
    private static final String port = "587"; // Reemplaza con el puerto SMTP adecuado
    private static final String userEmail = "correo"; // Reemplaza con tu email
    private static final String password = "contrasenia"; // Reemplaza con tu contraseña

    public static void sendTextEmail(String email, String asunto, String contenido){      
        
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host); // Reemplaza con tu servidor SMTP
        properties.put("mail.smtp.port", port); // Reemplaza con el puerto SMTP adecuado
        properties.put("mail.smtp.auth", "true"); // Si se requiere autenticación
        properties.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication( userEmail, password);
            }
        });
        
         try {
            // Crear un objeto MimeMessage
            Message message = new MimeMessage(session);

            // Establecer el remitente
            message.setFrom(new InternetAddress(userEmail));

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
