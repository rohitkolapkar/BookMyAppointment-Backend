package com.bookmyappointment.service;

import org.springframework.stereotype.Service;

import com.bookmyappointment.entity.Notification;
import com.bookmyappointment.util.BaseResponse;

import jakarta.servlet.http.HttpServletRequest;

@Service
public interface NotificationService {

	BaseResponse<Notification> saveNotification(HttpServletRequest request, Notification notification);

	void sendMail(HttpServletRequest request, Notification notification);

}
