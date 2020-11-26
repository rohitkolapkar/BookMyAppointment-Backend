package com.bookmyappointment.service;

import com.bookmyappointment.entity.BusinessEntity;
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
    NotificationService notificationService;
    @Autowired
    

    public BaseResponse<BusinessEntity> saveBusinessDetail(HttpServletRequest request, BusinessEntity business){

        BaseResponse<BusinessEntity> baseResponse = new BaseResponse<>();
        business = repository.save(business);
        //if(business)
        //
        
        
        baseResponse.setResponseObject(business);
        baseResponse.setStatus(CommonConstants.SUCCESS);
        baseResponse.setReasonText("Business Added successfully");
        baseResponse.setReasonCode("200");

        return baseResponse;

    }
}
