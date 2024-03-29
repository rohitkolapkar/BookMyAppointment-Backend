package com.bookmyappointment.service;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bookmyappointment.entity.Notification;
import com.bookmyappointment.repository.NotificationRepository;
import com.bookmyappointment.util.BaseResponse;
import com.bookmyappointment.util.CommonConstants;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	NotificationRepository repository;
	
	
	
	@Value("${mailusername}")
	private String mailusername;

	@Value("${password}")
	private String password;
	
	@Value("${SMTP}")
	private String SMTP;
	
	@Value("${Port}")
	private String Port;

	@Override
	public BaseResponse<Notification> saveNotification(HttpServletRequest request, Notification notification) {
		
		BaseResponse<Notification> baseResponse = new BaseResponse<>();
		notification = repository.save(notification);
		baseResponse.setResponseObject(notification);
		baseResponse.setStatus(CommonConstants.SUCCESS);
		baseResponse.setReasonText("Notification Added successfully");
		baseResponse.setReasonCode("200");
		
		
		return baseResponse;
	}
	
	@Override
	public void sendMail(HttpServletRequest request, Notification notification) {
		
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        
        Session session = Session.getInstance(prop,
                new jakarta.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(mailusername, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("mailusername"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(notification.getToMail())
            );
            //cc
            if(null != notification.getCcMail())
            message.setRecipients(
                    Message.RecipientType.CC,
                    InternetAddress.parse(notification.getCcMail())
            );
            //bcc
            if(null != notification.getBccmail())
            message.setRecipients(
                    Message.RecipientType.BCC,
                    InternetAddress.parse(notification.getBccmail())
            );
            
            message.setSubject(notification.getSubject());
            message.setText(notification.getBody());

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    
	}
	

}
