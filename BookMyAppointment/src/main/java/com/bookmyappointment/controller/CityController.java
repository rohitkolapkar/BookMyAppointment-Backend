package com.bookmyappointment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyappointment.entity.CityEntity;
import com.bookmyappointment.service.CityService;
import com.bookmyappointment.util.BaseResponse;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/v1/city")
public class CityController {

    @Autowired
    CityService service;

    public CityController() {
        System.out.println("in constructor of "+getClass().getName());
    }

    @PostMapping()
    public ResponseEntity<BaseResponse<CityEntity>> RegisterCity(HttpServletRequest request,
                                                                     @RequestBody CityEntity city) {
        BaseResponse<CityEntity> cityResponse = new BaseResponse<CityEntity>();
        ResponseEntity<BaseResponse<CityEntity>> response = null;
        cityResponse = service.saveCity(request,city);
        response = new ResponseEntity<BaseResponse<CityEntity>>(cityResponse, null, HttpStatus.OK);
        return response;
    }

    @GetMapping()
    public ResponseEntity<BaseResponse<CityEntity>> getAllCity(HttpServletRequest request,
                                                                 HttpServletResponse response) {
        BaseResponse<CityEntity> cityResponse = new BaseResponse<CityEntity>();
        ResponseEntity<BaseResponse<CityEntity>> getCityResponse = null;
        cityResponse = service.gateAllCity(request,response);
        getCityResponse = new ResponseEntity<BaseResponse<CityEntity>>(cityResponse, null, HttpStatus.OK);
        return getCityResponse;
    }
}
