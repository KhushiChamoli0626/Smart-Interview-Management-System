package com.khushi.smart_interview_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // ===============================
    // Send Interview Schedule Email
    // ===============================
    public void sendInterviewEmail(
            String candidateEmail,
            String candidateName,
            String jobTitle,
            String interviewerName,
            String interviewDateTime) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(candidateEmail);
        message.setSubject("Interview Scheduled - Smart Interview Management");

        String emailBody =
                "Dear " + candidateName + ",\n\n"
                + "Congratulations! Your interview has been scheduled.\n\n"

                + "Interview Details:\n"
                + "---------------------------------\n"
                + "Job Position : " + jobTitle + "\n"
                + "Interviewer  : " + interviewerName + "\n"
                + "Date & Time  : " + interviewDateTime + "\n"
                + "---------------------------------\n\n"

                + "Please be available 10 minutes before the scheduled time.\n"
                + "Kindly carry all necessary documents.\n\n"

                + "Best Wishes!\n\n"

                + "Regards,\n"
                + "HR Team\n"
                + "Smart Interview Management";

        message.setText(emailBody);

        mailSender.send(message);

        System.out.println("Interview email sent successfully to " + candidateEmail);
    }

    // ===============================
    // Generic Email (Optional)
    // ===============================
    public void sendEmail(String to, String subject, String body) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);

        System.out.println("Email sent successfully to " + to);
    }
}