package com.bookmyappointment.service;


import com.bookmyappointment.entity.ServiceProviderEntity;
import com.bookmyappointment.util.BaseResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface ServiceProviderService {
	
    BaseResponse<ServiceProviderEntity> saveServiceProvider(HttpServletRequest request, ServiceProviderEntity business);
}