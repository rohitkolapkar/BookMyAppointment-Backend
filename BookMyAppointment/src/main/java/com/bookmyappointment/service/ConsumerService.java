package com.bookmyappointment.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.bookmyappointment.entity.ConsumerEntity;
import com.bookmyappointment.util.BaseResponse;

@Service
public interface ConsumerService {

    BaseResponse<ConsumerEntity> saveUserDetail(HttpServletRequest request, ConsumerEntity user);

}
