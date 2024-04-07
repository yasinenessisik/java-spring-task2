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


    public void sendConfirmationEmail(String email,String subject,String body,String customerId,String reservationId){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("cercaslusaj@gmail.com");
        message.setTo(email);
        message.setText(body + String.format("\n\nClick the following link to proceed: http://localhost:3000/confirmreservation/%s/%s",customerId,reservationId));
        message.setSubject(subject);
        javaMailSender.send(message);
        System.out.println(message.getText().toString());
    }
}
