package com.bookmyappointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyappointment.entity.ServiceCategoryEntity;
import com.bookmyappointment.service.CategoryService;
import com.bookmyappointment.util.BaseResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    CategoryService service;

    public CategoryController() {
        System.out.println("in constructor of "+getClass().getName());
    }

    @PostMapping()
    public ResponseEntity<BaseResponse<ServiceCategoryEntity>> RegisterCategory(HttpServletRequest request,
                                                                     @RequestBody ServiceCategoryEntity city) {
        BaseResponse<ServiceCategoryEntity> cityResponse = new BaseResponse<ServiceCategoryEntity>();
        ResponseEntity<BaseResponse<ServiceCategoryEntity>> response = null;
        cityResponse = service.saveCategory(request,city);
        response = new ResponseEntity<BaseResponse<ServiceCategoryEntity>>(cityResponse, null, HttpStatus.OK);
        return response;
    }

    @GetMapping()
    public ResponseEntity<BaseResponse<ServiceCategoryEntity>> getAllCategory(HttpServletRequest request,
                                                                 HttpServletResponse response) {
        BaseResponse<ServiceCategoryEntity> cityResponse = new BaseResponse<ServiceCategoryEntity>();
        ResponseEntity<BaseResponse<ServiceCategoryEntity>> getCityResponse = null;
        cityResponse = service.gateAllCategory(request,response);
        getCityResponse = new ResponseEntity<BaseResponse<ServiceCategoryEntity>>(cityResponse, null, HttpStatus.OK);
        return getCityResponse;
    }
}
