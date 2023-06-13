package com.bookmyappointment.service;

import org.springframework.stereotype.Service;

import com.bookmyappointment.entity.ConsumerEntity;
import com.bookmyappointment.util.BaseResponse;

import jakarta.servlet.http.HttpServletRequest;

@Service
public interface ConsumerService {

    BaseResponse<ConsumerEntity> saveUserDetail(HttpServletRequest request, ConsumerEntity user);

}
