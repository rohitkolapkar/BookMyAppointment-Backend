package com.bookmyappointment.service;


import org.springframework.stereotype.Service;

import com.bookmyappointment.entity.ServiceCategoryEntity;
import com.bookmyappointment.util.BaseResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Service
public interface CategoryService {
    BaseResponse<ServiceCategoryEntity> saveCategory(HttpServletRequest request, ServiceCategoryEntity Category);

    BaseResponse<ServiceCategoryEntity> gateAllCategory(HttpServletRequest request, HttpServletResponse response);
}
