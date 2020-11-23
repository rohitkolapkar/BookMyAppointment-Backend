package com.bookmyappointment.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.bookmyappointment.entity.Notification;
import com.bookmyappointment.util.BaseResponse;

@Service
public interface NotificationService {

	BaseResponse<Notification> saveNotification(HttpServletRequest request, Notification notification);

	void sendMail(HttpServletRequest request, Notification notification);

}
