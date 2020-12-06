package com.bookmyappointment.controller;

import javax.servlet.http.HttpServletRequest;

import com.bookmyappointment.entity.AuthenticationEntity;
import com.bookmyappointment.entity.ServiceProviderEntity;
import com.bookmyappointment.entity.ConsumerEntity;
import com.bookmyappointment.service.AuthenticationService;
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
@RequestMapping("api/v1/authenticateUser")
public class AuthenticationController {

    @Autowired
    AuthenticationService service;

    @PostMapping()
    public ResponseEntity<BaseResponse<AuthenticationEntity>> authenticateUser(HttpServletRequest request,
                                                                               @RequestBody AuthenticationEntity user) {
        BaseResponse<AuthenticationEntity> userResponse = new BaseResponse<>();

        ResponseEntity<BaseResponse<AuthenticationEntity>> response = null;
        userResponse = service.authenticateUser(request, user);
        response = new ResponseEntity<BaseResponse<AuthenticationEntity>>(userResponse, null, HttpStatus.OK);
        return response;

    }
    
    @PostMapping("/forgot")
    public ResponseEntity<BaseResponse<AuthenticationEntity>> forgotPassword(HttpServletRequest request,
                                                                               @RequestBody AuthenticationEntity user) {
        BaseResponse<AuthenticationEntity> userResponse = new BaseResponse<>();

        ResponseEntity<BaseResponse<AuthenticationEntity>> response = null;
        userResponse = service.forgotPassword(request, user);
        response = new ResponseEntity<BaseResponse<AuthenticationEntity>>(userResponse, null, HttpStatus.OK);
        return response;

    }
    
    
}