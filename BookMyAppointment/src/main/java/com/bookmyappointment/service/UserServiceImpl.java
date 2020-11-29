package com.bookmyappointment.service;

import com.bookmyappointment.controller.NotificationContoller;
import com.bookmyappointment.entity.AuthenticationEntity;
import com.bookmyappointment.entity.Notification;
import com.bookmyappointment.entity.UserEntity;
import com.bookmyappointment.util.BaseResponse;
import com.bookmyappointment.util.CommonConstants;
import com.bookmyappointment.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    UserRepository repository;

    @Autowired
    AuthenticationService authService;

    @Autowired
    NotificationContoller notificationContoller;

    @Override
    public BaseResponse<UserEntity> saveUserDetail(HttpServletRequest request, UserEntity user) {

        BaseResponse<UserEntity> baseResponse = new BaseResponse<>();
        //Save Business
        user = repository.save(user);

        //Save Authentication Detail
        BaseResponse<AuthenticationEntity> authentication = new BaseResponse<>();
        AuthenticationEntity authenticationEntity = new AuthenticationEntity();
        authenticationEntity.setEmail(user.getEmail());
        authenticationEntity.setMobile(user.getMobile());
        authenticationEntity.setRole("user");
        authentication = authService.saveAuthenticationDetail(request,authenticationEntity);

        //Send Mail
        Notification notification = new Notification();
        notification.setToMail(user.getEmail());
        notification.setUserName(user.getName());
        notification.setBccmail(CommonConstants.BCC_mail);
        notification.setSubject(CommonConstants.Business_Registration_Subject);
        String MailBody = CommonConstants.Business_Registration_Body + "Login with following Detail \n\n "+ "UserName: "+authentication.getResponseObject().getEmail()+"\n\n password: "+ authentication.getResponseObject().getPassword();
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
