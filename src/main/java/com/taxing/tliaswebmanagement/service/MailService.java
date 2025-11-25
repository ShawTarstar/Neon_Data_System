package com.taxing.tliaswebmanagement.service;

public interface MailService {
    void sendSimpleMail(String to, String subject, String content);
}
