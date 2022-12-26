package com.bookmyappointment.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.bookmyappointment.entity.AuthenticationEntity;
import com.bookmyappointment.util.BaseResponse;

@Service
public interface AuthenticationService {

	BaseResponse<AuthenticationEntity> saveAuthenticationDetail(HttpServletRequest request, AuthenticationEntity authentication);

	BaseResponse<AuthenticationEntity> authenticateUser(HttpServletRequest request,
			AuthenticationEntity authentication);

	BaseResponse<AuthenticationEntity> forgotPassword(HttpServletRequest request,
			AuthenticationEntity authenticationEntity);

	public Boolean CheckUserExists(String emailId);

}
