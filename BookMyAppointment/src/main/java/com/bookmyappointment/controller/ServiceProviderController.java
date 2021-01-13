package com.bookmyappointment.controller;


import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyappointment.entity.CityEntity;
import com.bookmyappointment.entity.ServiceCategoryEntity;
import com.bookmyappointment.entity.ServiceProviderEntity;
import com.bookmyappointment.service.ServiceProviderService;
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
    
    @GetMapping(path="/search")
    public ResponseEntity<BaseResponse<ServiceProviderEntity>> getServiceProviders(HttpServletRequest request,
    		@RequestParam("cityId") int cityId,@RequestParam("categoryId") int categoryId) {
    	BaseResponse<ServiceProviderEntity> serviceProviderResponse = new BaseResponse<>();
        ResponseEntity<BaseResponse<ServiceProviderEntity>> response = null;
        serviceProviderResponse = service.gateAllServiceProviderByCityCategory(request,cityId,categoryId);
        response = new ResponseEntity<BaseResponse<ServiceProviderEntity>>(serviceProviderResponse, null, HttpStatus.OK);
        return response;
    }
    

}
