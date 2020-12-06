package com.bookmyappointment.service;

import com.bookmyappointment.entity.ConsumerEntity;
import com.bookmyappointment.util.BaseResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface ConsumerService {

    BaseResponse<ConsumerEntity> saveUserDetail(HttpServletRequest request, ConsumerEntity user);

}
