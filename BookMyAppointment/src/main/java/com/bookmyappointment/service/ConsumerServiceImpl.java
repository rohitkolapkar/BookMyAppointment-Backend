package com.bookmyappointment.service;

import com.bookmyappointment.controller.NotificationContoller;
import com.bookmyappointment.entity.AuthenticationEntity;
import com.bookmyappointment.entity.Notification;
import com.bookmyappointment.entity.ConsumerEntity;
import com.bookmyappointment.util.BaseResponse;
import com.bookmyappointment.util.CommonConstants;
import com.bookmyappointment.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;

@Service
public class ConsumerServiceImpl implements  ConsumerService{

    @Autowired
    ConsumerRepository repository;

    @Autowired
    AuthenticationService authService;

    @Autowired
    NotificationContoller notificationContoller;

    @Override
    public BaseResponse<ConsumerEntity> saveUserDetail(HttpServletRequest request, ConsumerEntity user) {

        BaseResponse<ConsumerEntity> baseResponse = new BaseResponse<>();
        //Save Business
        Boolean UserExists = authService.CheckUserExists(user.getConsumerEmail());
        if(UserExists){
            //if user is already present in system return error
            baseResponse.setStatus(CommonConstants.FAIL);
            baseResponse.setReasonText("You have already registered with us. Please try to log in");
            baseResponse.setReasonCode("400");

            return baseResponse;

        }else {
            user = repository.save(user);

            //Save Authentication Detail
            BaseResponse<AuthenticationEntity> authentication = new BaseResponse<>();

            //create AuthenticationEntity Object
            AuthenticationEntity authenticationEntity = new AuthenticationEntity();
            authenticationEntity.setName(user.getConsumerName());
            authenticationEntity.setEmail(user.getConsumerEmail());
            authenticationEntity.setMobile(user.getConsumerPhone());
            authenticationEntity.setPassword(user.getConsumerPassword());
            authenticationEntity.setActive(true);
            authenticationEntity.setRole("consumer");
            authenticationEntity.setConsumerId(user.getId());

            authentication = authService.saveAuthenticationDetail(request, authenticationEntity);

            //Send Mail
            Notification notification = new Notification();
            notification.setToMail(user.getConsumerEmail());
            notification.setUserName(user.getConsumerName());
            notification.setBccmail(CommonConstants.BCC_MAIL);
            notification.setSubject(CommonConstants.CUSTOMER_REGISTRATION_SUBJECT);
            String MailBody = CommonConstants.CUSTOMER_REGISTRATION_BODY + "Login with following Detail \n\n " + "UserName: " + user.getConsumerEmail() + "\n\n password: " + user.getConsumerPassword();
            notification.setBody(MailBody);
            notificationContoller.saveNotification(request, notification);

            // Set BaseResponse
            baseResponse.setResponseObject(user);
            baseResponse.setStatus(CommonConstants.SUCCESS);
            baseResponse.setReasonText("Consumer Registration Successful");
            baseResponse.setReasonCode("200");

            return baseResponse;
        }

    }
}
