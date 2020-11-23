package com.bookmyappointment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/c")
public class CustomerController {
	public CustomerController() {
		System.out.println("in constructor of "+getClass().getName());
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<?> getCustomer(@PathVariable String customerId){
		return new ResponseEntity<>(customerId, HttpStatus.OK);
		
	}
	
}
