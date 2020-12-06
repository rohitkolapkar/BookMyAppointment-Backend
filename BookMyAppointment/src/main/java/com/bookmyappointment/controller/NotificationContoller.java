package com.bookmyappointment.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyappointment.entity.Notification;
import com.bookmyappointment.service.NotificationService;
import com.bookmyappointment.util.BaseResponse;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/v1/Notification")
public class NotificationContoller {
	
	@Autowired
	NotificationService service;
	
	@PostMapping()
	public ResponseEntity<BaseResponse<Notification>> saveNotification(HttpServletRequest request,
			@RequestBody Notification notification) {
		
		BaseResponse<Notification> notificationResponse = new BaseResponse<Notification>();

		ResponseEntity<BaseResponse<Notification>> response = null;
		notification.setCreatedDate(Calendar.getInstance().getTime());
		notificationResponse = service.saveNotification(request,notification);
		
		service.sendMail(request,notification);
		
		notification = notificationResponse.getResponseObject();
		notification.setLastModifiedDate(Calendar.getInstance().getTime());
		notification.setStatus("Success");
		
		notificationResponse = service.saveNotification(request,notification);
		
		response = new ResponseEntity<BaseResponse<Notification>>(notificationResponse, null, HttpStatus.OK);
		
		return response;			
	}
	
	

	
}

