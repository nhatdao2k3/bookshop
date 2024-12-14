package com.group2.bookshopwebsite.service;

public interface EmailService {
    void sendSimpleEmail(String to, String subject, String text);
}
