package com.bookmyappointment.service;

import com.bookmyappointment.entity.CityEntity;
import com.bookmyappointment.util.BaseResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public interface CityService {
	
    BaseResponse<CityEntity> saveCity(HttpServletRequest request, CityEntity city);

    BaseResponse<CityEntity> gateAllCity(HttpServletRequest request, HttpServletResponse response);
}
