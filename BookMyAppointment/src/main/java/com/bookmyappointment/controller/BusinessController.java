package com.bookmyappointment.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import com.bookmyappointment.entity.BusinessEntity;
import com.bookmyappointment.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyappointment.util.BaseResponse;


@RestController
@RequestMapping("api/v1/Business")
public class BusinessController {

    @Autowired
    BusinessService service;

    @PostMapping()
    public ResponseEntity<BaseResponse<BusinessEntity>> saveBusinessDetail(HttpServletRequest request,
                                                                           @RequestBody BusinessEntity business) {
        BaseResponse<BusinessEntity> businessonResponse = new BaseResponse<BusinessEntity>();

        ResponseEntity<BaseResponse<BusinessEntity>> response = null;

        businessonResponse = service.saveBusinessDetail(request,business);

        response = new ResponseEntity<BaseResponse<BusinessEntity>>(businessonResponse, null, HttpStatus.OK);

        return response;


    }

}
