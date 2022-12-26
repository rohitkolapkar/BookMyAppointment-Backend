package com.bookmyappointment.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.bookmyappointment.entity.ServiceCategoryEntity;
import com.bookmyappointment.util.BaseResponse;
@Service
public interface CategoryService {
    BaseResponse<ServiceCategoryEntity> saveCategory(HttpServletRequest request, ServiceCategoryEntity Category);

    BaseResponse<ServiceCategoryEntity> gateAllCategory(HttpServletRequest request, HttpServletResponse response);
}
