package com.bookmyappointment.service;

import com.bookmyappointment.controller.NotificationContoller;
import com.bookmyappointment.entity.BusinessEntity;
import com.bookmyappointment.entity.Notification;
import com.bookmyappointment.util.BaseResponse;
import com.bookmyappointment.util.CommonConstants;
import com.bookmyappointment.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class BusinessServiceImpl implements BusinessService{

    @Autowired
    BusinessRepository repository;
    @Autowired
    NotificationContoller notificationContoller;
    @Autowired
    Notification notification;
    @Autowired
    CommonConstants constants;

    public BaseResponse<BusinessEntity> saveBusinessDetail(HttpServletRequest request, BusinessEntity business){

        BaseResponse<BusinessEntity> baseResponse = new BaseResponse<>();
        business = repository.save(business);

        notification.setToMail(business.getBusinessEmail());
        notification.setUserName(business.getBusinessName());
        notification.setBccmail(constants.BCC_mail);
        notification.setSubject(constants.Business_Registration_Subject);
        notification.setBody(constants.Business_Registration_Body);

        notificationContoller.saveNotification(request,notification);
        
        baseResponse.setResponseObject(business);
        baseResponse.setStatus(CommonConstants.SUCCESS);
        baseResponse.setReasonText("Business Added successfully");
        baseResponse.setReasonCode("200");

        return baseResponse;

    }
}
