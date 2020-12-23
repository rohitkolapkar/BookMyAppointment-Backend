package com.bookmyappointment.service;


import com.bookmyappointment.entity.ServiceProviderEntity;
import com.bookmyappointment.util.BaseResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public interface ServiceProviderService {
	
    BaseResponse<ServiceProviderEntity> saveServiceProvider(HttpServletRequest request, ServiceProviderEntity business);

    BaseResponse<ServiceProviderEntity> gateAllServiceProvider(HttpServletRequest request, String cityName);
}