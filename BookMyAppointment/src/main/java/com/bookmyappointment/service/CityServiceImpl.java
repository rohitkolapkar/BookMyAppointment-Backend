package com.bookmyappointment.service;

import com.bookmyappointment.entity.CityEntity;
import com.bookmyappointment.repository.CityRepository;
import com.bookmyappointment.util.BaseResponse;
import com.bookmyappointment.util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository repository;

    @Override
    public BaseResponse<CityEntity> saveCity(HttpServletRequest request, CityEntity city) {
        BaseResponse<CityEntity> baseResponse = new BaseResponse<>();
        city = repository.save(city);
        baseResponse.setResponseObject(city);
        baseResponse.setStatus(CommonConstants.SUCCESS);
        baseResponse.setReasonText("City Added successfully");
        baseResponse.setReasonCode("200");
        return baseResponse;
    }

    @Override
    public BaseResponse<CityEntity> gateAllCity(HttpServletRequest request, HttpServletResponse response) {
        BaseResponse<CityEntity> baseResponse = new BaseResponse<>();
        List<CityEntity> entity = repository.findAll();  
        baseResponse.setResponseListObject(entity);
        baseResponse.setStatus(CommonConstants.SUCCESS);
        baseResponse.setReasonText("find All city");
        baseResponse.setReasonCode("200");
        return baseResponse;
    }
}
