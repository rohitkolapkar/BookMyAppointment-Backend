package com.bookmyappointment.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyappointment.entity.ServiceEntity;
import com.bookmyappointment.service.ServicesService;
import com.bookmyappointment.util.BaseResponse;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/v1/services")
public class ServicesController {

    @Autowired
    ServicesService service;

    public ServicesController() {
        System.out.println("in constructor of "+getClass().getName());
    }

    @PostMapping()
    public ResponseEntity<BaseResponse<ServiceEntity>> AddService(HttpServletRequest request,
                                                                 @RequestBody ServiceEntity serviceObj) {

        BaseResponse<ServiceEntity> serviceResponse = service.saveService(request,serviceObj);
        ResponseEntity<BaseResponse<ServiceEntity>> response = new ResponseEntity<BaseResponse<ServiceEntity>>(serviceResponse, null, HttpStatus.OK);
        return response;
    }

    @GetMapping(path="/search")
    public ResponseEntity<BaseResponse<ServiceEntity>> getServicesBySpId(HttpServletRequest request,
                                                                         @RequestParam("spId") int SpId) {

        BaseResponse<ServiceEntity> cityResponse =  service.getServicesBySpId(request,SpId);
        ResponseEntity<BaseResponse<ServiceEntity>> getCityResponse = new ResponseEntity<BaseResponse<ServiceEntity>>(cityResponse, null, HttpStatus.OK);
        return getCityResponse;
    }
}
