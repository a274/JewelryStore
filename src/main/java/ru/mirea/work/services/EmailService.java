package ru.mirea.work.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;

/**
 * Класс-сервис для отправки сообщений на электронную почту
 */
@Service
public class EmailService {

    /**
     * Асинхронный метод отправки сообщения на почту
     */
    @Async
    public void sendmail(String mail, String message, boolean isManager) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("example@gmail.com", "******");
            }
        });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("example@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
        if (isManager)
            msg.setSubject("Jewelry Store/Был оформлен новый заказ");
        else
            msg.setSubject("Jewelry Store/был оформлен новый заказ");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html; charset=UTF-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        msg.setContent(multipart);
        Transport.send(msg);
    }
}
