package com.javaspringtask2.javaspringtask2.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    private final JavaMailSender javaMailSender;


    public EmailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public void sendEmail(String email,String subject,String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("cercaslusaj@gmail.com");
        message.setTo(email);
        message.setText(body);
        message.setSubject(subject);
        javaMailSender.send(message);

    }
}
