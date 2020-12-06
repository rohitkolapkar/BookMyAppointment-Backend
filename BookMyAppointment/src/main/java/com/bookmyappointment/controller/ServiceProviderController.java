package com.bookmyappointment.controller;


import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import com.bookmyappointment.entity.ServiceProviderEntity;
import com.bookmyappointment.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyappointment.util.BaseResponse;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/v1/serviceProvider")
public class ServiceProviderController {

    @Autowired
    ServiceProviderService service;

    @PostMapping()
    public ResponseEntity<BaseResponse<ServiceProviderEntity>> saveBusinessDetail(HttpServletRequest request,
                                                                           @RequestBody ServiceProviderEntity business) {
        BaseResponse<ServiceProviderEntity> businessonResponse = new BaseResponse<ServiceProviderEntity>();

        ResponseEntity<BaseResponse<ServiceProviderEntity>> response = null;

        businessonResponse = service.saveBusinessDetail(request,business);

        response = new ResponseEntity<BaseResponse<ServiceProviderEntity>>(businessonResponse, null, HttpStatus.OK);

        return response;


    }

}
