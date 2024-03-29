package com.bookmyappointment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyappointment.entity.ServiceCategoryEntity;
import com.bookmyappointment.repository.CategoryRepository;
import com.bookmyappointment.util.BaseResponse;
import com.bookmyappointment.util.CommonConstants;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository repository;

    @Override
    public BaseResponse<ServiceCategoryEntity> saveCategory(HttpServletRequest request, ServiceCategoryEntity Category) {
        BaseResponse<ServiceCategoryEntity> baseResponse = new BaseResponse<>();
        Category = repository.save(Category);
        baseResponse.setResponseObject(Category);
        baseResponse.setStatus(CommonConstants.SUCCESS);
        baseResponse.setReasonText("Category Added successfully");
        baseResponse.setReasonCode("200");
        return baseResponse;
    }

    @Override
    public BaseResponse<ServiceCategoryEntity> gateAllCategory(HttpServletRequest request, HttpServletResponse response) {
        BaseResponse<ServiceCategoryEntity> baseResponse = new BaseResponse<>();
        List<ServiceCategoryEntity> entity = repository.findAll();
        baseResponse.setResponseListObject(entity);
        baseResponse.setStatus(CommonConstants.SUCCESS);
        baseResponse.setReasonText("find All Category successfully");
        baseResponse.setReasonCode("200");
        return baseResponse;
    }
}
