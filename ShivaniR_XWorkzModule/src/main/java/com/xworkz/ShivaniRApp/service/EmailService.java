package com.xworkz.ShivaniRApp.service;

public interface EmailService {
    void sendEmailToBatch(int batchId, String subject, String body);
}
