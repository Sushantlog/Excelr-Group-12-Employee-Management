package com.excelr.ems_backend.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.ems_backend.service.EmailService;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody Map<String, String> request) {
    	String toEmail = request.get("toEmail");
    	emailService.sendSimpleEmail(toEmail, "Test Subject", "This is a test email.");
        return "Email sent successfully!";
    }
}
