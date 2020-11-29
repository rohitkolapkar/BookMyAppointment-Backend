package com.bookmyappointment.controller;

import com.bookmyappointment.entity.BusinessEntity;
import com.bookmyappointment.entity.CustomerEntity;
import com.bookmyappointment.service.CustomerService;
import com.bookmyappointment.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

	@Autowired
	CustomerService service;

	public CustomerController() {
		System.out.println("in constructor of "+getClass().getName());
	}

	@PostMapping()
	public ResponseEntity<BaseResponse<CustomerEntity>> RegisterUser(HttpServletRequest request,
																 @RequestBody CustomerEntity user) {
		BaseResponse<CustomerEntity> userResponse = new BaseResponse<CustomerEntity>();

		ResponseEntity<BaseResponse<CustomerEntity>> response = null;

		userResponse = service.saveUserDetail(request,user);

		response = new ResponseEntity<BaseResponse<CustomerEntity>>(userResponse, null, HttpStatus.OK);

		return response;


	}

	@GetMapping("/{customerId}")
	public ResponseEntity<?> getCustomer(@PathVariable String customerId){
		return new ResponseEntity<>(customerId, HttpStatus.OK);
		
	}
	
}
