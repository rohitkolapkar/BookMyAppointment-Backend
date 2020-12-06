package com.bookmyappointment.service;

import com.bookmyappointment.controller.NotificationContoller;
import com.bookmyappointment.entity.AuthenticationEntity;
import com.bookmyappointment.entity.ServiceProviderEntity;
import com.bookmyappointment.entity.Notification;
import com.bookmyappointment.util.BaseResponse;
import com.bookmyappointment.util.CommonConstants;
import com.bookmyappointment.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService{

    @Autowired
    ServiceProviderRepository repository;

    @Autowired
    AuthenticationService authService;

    @Autowired
    NotificationContoller notificationContoller;
    

    public BaseResponse<ServiceProviderEntity> saveBusinessDetail(HttpServletRequest request, ServiceProviderEntity business){

        BaseResponse<ServiceProviderEntity> baseResponse = new BaseResponse<>();
        //Save Business
        business = repository.save(business);

        //Save Authentication Detail
        BaseResponse<AuthenticationEntity> authentication = new BaseResponse<>();
        AuthenticationEntity authenticationEntity = new AuthenticationEntity();
        authenticationEntity.setName(business.getBusinessName());
        authenticationEntity.setEmail(business.getBusinessEmail());
        authenticationEntity.setMobile(business.getMobile());
        authenticationEntity.setRole("serviceProvider");
        authentication = authService.saveAuthenticationDetail(request,authenticationEntity);

        //Send Mail
        Notification notification = new Notification();
        notification.setToMail(business.getBusinessEmail());
        notification.setUserName(business.getBusinessName());
        notification.setBccmail(CommonConstants.BCC_MAIL);
        notification.setSubject(CommonConstants.BUSINESS_REGISTRATION_SUBJECT);
        String MailBody = CommonConstants.BUSINESS_REGISTRATION_BODY + "Login with following Detail \n\n "+ "UserName: "+authentication.getResponseObject().getEmail()+"\n\n password: "+ authentication.getResponseObject().getPassword();
        notification.setBody(MailBody);
        notificationContoller.saveNotification(request,notification);

        // Set BaseResponse
        baseResponse.setResponseObject(business);
        baseResponse.setStatus(CommonConstants.SUCCESS);
        baseResponse.setReasonText("Business Added successfully");
        baseResponse.setReasonCode("200");

        return baseResponse;

    }
}
