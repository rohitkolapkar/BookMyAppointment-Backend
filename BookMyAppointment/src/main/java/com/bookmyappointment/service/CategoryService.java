package com.bookmyappointment.service;


import com.bookmyappointment.entity.ServiceCategoryEntity;
import com.bookmyappointment.util.BaseResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Service
public interface CategoryService {
    BaseResponse<ServiceCategoryEntity> saveCategory(HttpServletRequest request, ServiceCategoryEntity Category);

    BaseResponse<ServiceCategoryEntity> gateAllCategory(HttpServletRequest request, HttpServletResponse response);
}
