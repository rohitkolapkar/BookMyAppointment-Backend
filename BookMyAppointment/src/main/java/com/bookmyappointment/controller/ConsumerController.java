package com.bookmyappointment.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyappointment.entity.ConsumerEntity;
import com.bookmyappointment.service.ConsumerService;
import com.bookmyappointment.util.BaseResponse;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/v1/consumer")
public class ConsumerController {

	@Autowired
	ConsumerService service;

	public ConsumerController() {
		System.out.println("in constructor of "+getClass().getName());
	}

	@PostMapping()
	public ResponseEntity<BaseResponse<ConsumerEntity>> RegisterUser(HttpServletRequest request,
																 @RequestBody ConsumerEntity user) {
		BaseResponse<ConsumerEntity> userResponse = new BaseResponse<ConsumerEntity>();

		ResponseEntity<BaseResponse<ConsumerEntity>> response = null;

		userResponse = service.saveUserDetail(request,user);

		response = new ResponseEntity<BaseResponse<ConsumerEntity>>(userResponse, null, HttpStatus.OK);

		return response;


	}

	@GetMapping("/{customerId}")
	public ResponseEntity<?> getCustomer(@PathVariable String customerId){
		return new ResponseEntity<>(customerId, HttpStatus.OK);
		
	}
	
}
