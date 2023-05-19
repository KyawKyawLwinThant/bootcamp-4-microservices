package com.example.apisecurity.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private final JavaMailSender javaMailSender;
    private final String defaultFrontEndUrl;

    public MailService(JavaMailSender javaMailSender
            ,@Value("http://localhost:8091") String defaultFrontEndUrl) {
        this.javaMailSender = javaMailSender;
        this.defaultFrontEndUrl = defaultFrontEndUrl;
    }
    public void sendMessage(String email,String token,String url){
        var defaultUrl=url!=null? url : defaultFrontEndUrl;
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("jdc@javalab.com");
        message.setTo(email);
        message.setSubject("Reset your password.");
        message.setText(String.format(
                "Click <a href=\"%s/api/reset/%s\">here</a> to reset your" +
                        "password.",
                url,
                token
        ));
        javaMailSender.send(message);

    }





}
