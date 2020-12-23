package com.bookmyappointment.controller;


import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmyappointment.entity.CityEntity;
import com.bookmyappointment.entity.ServiceProviderEntity;
import com.bookmyappointment.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(business.toString());
        businessonResponse = service.saveServiceProvider(request,business);

        response = new ResponseEntity<BaseResponse<ServiceProviderEntity>>(businessonResponse, null, HttpStatus.OK);

        return response;


    }

    @GetMapping(path="/{cityName}")
    public ResponseEntity<BaseResponse<ServiceProviderEntity>> getAllCity(HttpServletRequest request,
                                            @PathVariable("cityName") String cityName) {
        BaseResponse<ServiceProviderEntity> serviceProviderResponse = new BaseResponse<>();
        ResponseEntity<BaseResponse<ServiceProviderEntity>> response = null;
        serviceProviderResponse = service.gateAllServiceProvider(request,cityName);
        response = new ResponseEntity<BaseResponse<ServiceProviderEntity>>(serviceProviderResponse, null, HttpStatus.OK);
        return response;
    }

}
