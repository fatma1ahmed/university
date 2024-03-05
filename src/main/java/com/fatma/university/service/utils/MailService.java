package com.fatma.university.service.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender emailSender;

    public String sendMessageToEmail(String toEmail, String message) {
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        simpleMessage.setTo(toEmail);
        simpleMessage.setSubject("Helwan University Newline System");
        simpleMessage.setText(message);
        simpleMessage.setFrom("moaazsuliman1@gmail.com");
        emailSender.send(simpleMessage);
        return "Message Sent Successfully";
    }
}
