package com.xworkz.ShivaniRApp.service.impl;

import com.xworkz.ShivaniRApp.entity.StudentEntity;
import com.xworkz.ShivaniRApp.service.EmailService;
import com.xworkz.ShivaniRApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {


    @Autowired
    private StudentService studentService;

    @Value("${mail.username}")
    private String username;

    @Value("${mail.password}")
    private String password;

    @Override
    public void sendEmailToBatch(int batchId, String subject, String body) {

        List<StudentEntity> students =
                studentService.getStudentsByBatch(batchId);

        for (StudentEntity student : students) {
            sendMail(student.getEmail(), subject, body);
        }
    }

    private void sendMail(String toEmail, String subject, String content) {

        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            props.put("mail.smtp.ssl.protocols", "TLSv1.2");

            Session mailSession = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            Message message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
