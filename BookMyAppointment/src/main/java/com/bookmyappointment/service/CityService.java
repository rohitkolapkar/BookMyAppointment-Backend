package com.bookmyappointment.service;

import org.springframework.stereotype.Service;

import com.bookmyappointment.entity.CityEntity;
import com.bookmyappointment.util.BaseResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public interface CityService {
	
    BaseResponse<CityEntity> saveCity(HttpServletRequest request, CityEntity city);

    BaseResponse<CityEntity> gateAllCity(HttpServletRequest request, HttpServletResponse response);
}
