package com.bookmyappointment.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.bookmyappointment.entity.ServiceEntity;
import com.bookmyappointment.util.BaseResponse;
@Service
public interface ServicesService {
    BaseResponse<ServiceEntity> saveService(HttpServletRequest request, ServiceEntity serviceObj);

    BaseResponse<ServiceEntity> getServicesBySpId(HttpServletRequest request, int spId);
}
