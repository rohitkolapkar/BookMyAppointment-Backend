package com.bookmyappointment.service;

import com.bookmyappointment.entity.CityEntity;
import com.bookmyappointment.entity.ServiceEntity;
import com.bookmyappointment.repository.ServiceRepository;
import com.bookmyappointment.util.BaseResponse;
import com.bookmyappointment.util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class ServiceImpl implements ServicesService {
    @Autowired
    ServiceRepository repository;
    @Override
    public BaseResponse<ServiceEntity> saveService(HttpServletRequest request, ServiceEntity serviceObj) {
        BaseResponse<ServiceEntity> baseResponse = new BaseResponse<>();
        serviceObj = repository.save(serviceObj);
        baseResponse.setResponseObject(serviceObj);
        baseResponse.setStatus(CommonConstants.SUCCESS);
        baseResponse.setReasonText("Service Added successfully");
        baseResponse.setReasonCode("200");
        return baseResponse;
    }

    @Override
    public BaseResponse<ServiceEntity> getServicesBySpId(HttpServletRequest request, int spId) {
        BaseResponse<ServiceEntity> baseResponse = new BaseResponse<>();
        List<ServiceEntity> entity = repository.findByServiceProvider_SpId(spId);
        baseResponse.setResponseListObject(entity);
        baseResponse.setStatus(CommonConstants.SUCCESS);
        baseResponse.setReasonText("getServicesBySpId");
        baseResponse.setReasonCode("200");
        return baseResponse;
    }
}
