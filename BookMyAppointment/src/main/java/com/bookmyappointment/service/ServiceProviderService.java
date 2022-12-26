package com.bookmyappointment.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.bookmyappointment.entity.ServiceProviderEntity;
import com.bookmyappointment.util.BaseResponse;

@Service
public interface ServiceProviderService {
	
    BaseResponse<ServiceProviderEntity> saveServiceProvider(HttpServletRequest request, ServiceProviderEntity business);

    BaseResponse<ServiceProviderEntity> gateAllServiceProvider(HttpServletRequest request, String cityName);

	BaseResponse<ServiceProviderEntity> gateAllServiceProviderByCityCategory(HttpServletRequest request, int cityId,
			int categoryId);

}