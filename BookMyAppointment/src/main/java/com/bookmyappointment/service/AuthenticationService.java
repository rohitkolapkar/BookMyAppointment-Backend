package com.bookmyappointment.service;

import com.bookmyappointment.entity.AuthenticationEntity;
import com.bookmyappointment.entity.ConsumerEntity;
import com.bookmyappointment.util.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface AuthenticationService {

	BaseResponse<AuthenticationEntity> saveAuthenticationDetail(HttpServletRequest request, AuthenticationEntity authentication);

	BaseResponse<AuthenticationEntity> authenticateUser(HttpServletRequest request,
			AuthenticationEntity authentication);

	BaseResponse<AuthenticationEntity> forgotPassword(HttpServletRequest request,
			AuthenticationEntity authenticationEntity);

	public Boolean CheckUserExists(String emailId);

}
