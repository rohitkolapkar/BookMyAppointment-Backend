package com.bookmyappointment.service;

import com.bookmyappointment.controller.NotificationContoller;
import com.bookmyappointment.entity.AuthenticationEntity;
import com.bookmyappointment.entity.Notification;
import com.bookmyappointment.entity.CustomerEntity;
import com.bookmyappointment.util.BaseResponse;
import com.bookmyappointment.util.CommonConstants;
import com.bookmyappointment.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;

@Service
public class CustomerServiceImpl implements  CustomerService{

    @Autowired
    CustomerRepository repository;

    @Autowired
    AuthenticationService authService;

    @Autowired
    NotificationContoller notificationContoller;

    @Override
    public BaseResponse<CustomerEntity> saveUserDetail(HttpServletRequest request, CustomerEntity user) {

        BaseResponse<CustomerEntity> baseResponse = new BaseResponse<>();
        //Save Business
        user = repository.save(user);

        //Save Authentication Detail
        BaseResponse<AuthenticationEntity> authentication = new BaseResponse<>();
        AuthenticationEntity authenticationEntity = new AuthenticationEntity();
        authenticationEntity.setEmail(user.getEmail());
        authenticationEntity.setMobile(user.getMobile());
        authenticationEntity.setRole("customer");
        authentication = authService.saveAuthenticationDetail(request,authenticationEntity);

        //Send Mail
        Notification notification = new Notification();
        notification.setToMail(user.getEmail());
        notification.setUserName(user.getName());
        notification.setBccmail(CommonConstants.BCC_MAIL);
        notification.setSubject(CommonConstants.CUSTOMER_REGISTRATION_SUBJECT);
        String MailBody = CommonConstants.CUSTOMER_REGISTRATION_BODY + "Login with following Detail \n\n "+ "UserName: "+authentication.getResponseObject().getEmail()+"\n\n password: "+ authentication.getResponseObject().getPassword();
        notification.setBody(MailBody);
        notificationContoller.saveNotification(request,notification);

        // Set BaseResponse
        baseResponse.setResponseObject(user);
        baseResponse.setStatus(CommonConstants.SUCCESS);
        baseResponse.setReasonText("Business Added successfully");
        baseResponse.setReasonCode("200");

        return baseResponse;

    }
}
