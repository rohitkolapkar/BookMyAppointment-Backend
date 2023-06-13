package com.bookmyappointment.service;

import org.springframework.stereotype.Service;

import com.bookmyappointment.entity.ServiceEntity;
import com.bookmyappointment.util.BaseResponse;

import jakarta.servlet.http.HttpServletRequest;
@Service
public interface ServicesService {
    BaseResponse<ServiceEntity> saveService(HttpServletRequest request, ServiceEntity serviceObj);

    BaseResponse<ServiceEntity> getServicesBySpId(HttpServletRequest request, int spId);
}
