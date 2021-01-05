package com.mana.spring.service.impl;

import com.mana.spring.service.EmailService;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class EmailServiceImpl implements EmailService {
    private JavaMailSenderImpl mailSender;

    EmailServiceImpl() {
        mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("noreplydzicreations@gmail.com");
        mailSender.setPassword("mqhqydyxpmesvtvv");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.debug", "true");
    }


    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            message.setSubject(subject);
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("noreply@dzicreations.com");
            helper.setTo(to);
            helper.setText(text, true);
            mailSender.send(message);

            helper.setTo("noreplydzicreations@gmail.com");
            mailSender.send(message);
        } catch (Exception ex) {
//            Logger.getLogger(HTMLMail.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
    }
}
