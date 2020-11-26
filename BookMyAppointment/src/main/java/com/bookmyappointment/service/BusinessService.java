package com.bookmyappointment.service;


import com.bookmyappointment.entity.BusinessEntity;
import com.bookmyappointment.util.BaseResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface BusinessService {
	
    BaseResponse<BusinessEntity> saveBusinessDetail(HttpServletRequest request, BusinessEntity business);
}
