package com.bookmyappointment.service;


import org.springframework.stereotype.Service;

import com.bookmyappointment.entity.ServiceProviderEntity;
import com.bookmyappointment.util.BaseResponse;

import jakarta.servlet.http.HttpServletRequest;

@Service
public interface ServiceProviderService {
	
    BaseResponse<ServiceProviderEntity> saveServiceProvider(HttpServletRequest request, ServiceProviderEntity business);

    BaseResponse<ServiceProviderEntity> gateAllServiceProvider(HttpServletRequest request, String cityName);

	BaseResponse<ServiceProviderEntity> gateAllServiceProviderByCityCategory(HttpServletRequest request, int cityId,
			int categoryId);

}