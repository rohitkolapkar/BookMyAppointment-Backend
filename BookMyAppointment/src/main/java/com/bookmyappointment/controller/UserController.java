package com.bookmyappointment.controller;

import com.bookmyappointment.entity.BusinessEntity;
import com.bookmyappointment.entity.UserEntity;
import com.bookmyappointment.service.UserService;
import com.bookmyappointment.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

	@Autowired
	UserService service;

	public UserController() {
		System.out.println("in constructor of "+getClass().getName());
	}

	@PostMapping()
	public ResponseEntity<BaseResponse<UserEntity>> RegisterUser(HttpServletRequest request,
																 @RequestBody UserEntity user) {
		BaseResponse<UserEntity> userResponse = new BaseResponse<UserEntity>();

		ResponseEntity<BaseResponse<UserEntity>> response = null;

		userResponse = service.saveUserDetail(request,user);

		response = new ResponseEntity<BaseResponse<UserEntity>>(userResponse, null, HttpStatus.OK);

		return response;


	}

	@GetMapping("/{customerId}")
	public ResponseEntity<?> getCustomer(@PathVariable String customerId){
		return new ResponseEntity<>(customerId, HttpStatus.OK);
		
	}
	
}
