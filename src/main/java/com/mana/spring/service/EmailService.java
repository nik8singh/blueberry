package com.mana.spring.service;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);

}
