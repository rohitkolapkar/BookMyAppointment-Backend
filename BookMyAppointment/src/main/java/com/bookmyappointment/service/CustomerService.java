package com.bookmyappointment.service;

import com.bookmyappointment.entity.CustomerEntity;
import com.bookmyappointment.util.BaseResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface CustomerService {

    BaseResponse<CustomerEntity> saveUserDetail(HttpServletRequest request, CustomerEntity user);

}
