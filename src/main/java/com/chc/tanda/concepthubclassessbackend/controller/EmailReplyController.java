package com.chc.tanda.concepthubclassessbackend.controller;

import com.chc.tanda.concepthubclassessbackend.model.ContactUs;
import com.chc.tanda.concepthubclassessbackend.model.EmailReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 17, 2020
 */
@RestController
public class EmailReplyController {

    @Autowired
    JavaMailSender javaMailSender;

    @Value("$gmail.username")
    private String username;
    @Value("$gmail.password")
    private String password;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/sendEmail")
    public String sendEmail(@RequestBody EmailReply emailReply) throws MessagingException, AddressException, IOException {

        sendMail(emailReply);
        return "Email Send Successfully..!";
    }

    private void sendMail(EmailReply emailReply) throws MessagingException, AddressException {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

//        Session session = Session.getInstance(props,
//                new javax.mail.Authenticator() {
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(username, password);
//                    }
//                });

        //Message msg = new MimeMessage(session);

        MimeMessage msg = javaMailSender.createMimeMessage();
        msg.setFrom(new InternetAddress(username, false));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailReply.getEmail()));
        msg.setSubject(emailReply.getSubject());
        msg.setContent(emailReply.getMessage(), "text/html");
        msg.setSentDate(new Date());
        //msg.setText(emailReply.getName());
        msg.setText(emailReply.getMessage());
        //send email
        javaMailSender.send(msg);
    }
}
