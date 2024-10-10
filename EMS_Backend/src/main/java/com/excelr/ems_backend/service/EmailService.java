package com.excelr.ems_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendSimpleEmail(String toEmail, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(body);
		message.setFrom("sivaprasadgandepalli@gmail.com");

		mailSender.send(message);
	}

	public void sendProfileCreationEmail(String toEmail, String employeeName, String employmentCode,
			String companyEmail, String tempPassword, String companyPhone) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

		String htmlContent = "<!DOCTYPE html>" + "<html lang='en'>" + "<head>" + "    <meta charset='UTF-8'>"
				+ "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>"
				+ "    <title>Profile Created Notification</title>" + "    <style>"
				+ "        body {font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px;}"
				+ "        .email-container {background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1); max-width: 600px; margin: 0 auto;}"
				+ "        h2 {color: #333333;}" + "        p {color: #555555;}"
				+ "        .details-table {width: 100%; margin-top: 20px; border-collapse: collapse;}"
				+ "        .details-table th, .details-table td {padding: 10px; text-align: left; border-bottom: 1px solid #dddddd;}"
				+ "        .details-table th {background-color: #f4f4f4;}"
				+ "        .footer {margin-top: 30px; text-align: center; color: #999999; font-size: 12px;}"
				+ "    </style>" + "</head>" + "<body>" + "<div class='email-container'>" + "    <h2>Welcome to "
				+ "YourCompany" + "!</h2>" + "    <p>Dear " + employeeName + ",</p>"
				+ "    <p>Your profile has been created. Below are your details:</p>"
				+ "    <table class='details-table'>" + "        <tr><th>Employment Code:</th><td>" + employmentCode
				+ "</td></tr>" + "        <tr><th>Company Email:</th><td>" + companyEmail + "</td></tr>"
				+ "        <tr><th>Temporary Password:</th><td>" + tempPassword + "</td></tr>"
				+ "        <tr><th>Company Phone Number:</th><td>" + companyPhone + "</td></tr>" + "    </table>"
				+ "    <p>Best Regards,</p>" + "    <p>The Company Team</p>" + "</div>" + "</body>" + "</html>";

		helper.setTo(toEmail);
		helper.setSubject("Your Profile has been created");
		helper.setText(htmlContent, true);

		mailSender.send(mimeMessage);
	}
}
