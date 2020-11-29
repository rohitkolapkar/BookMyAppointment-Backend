package com.bookmyappointment.service;

import com.bookmyappointment.entity.UserEntity;
import com.bookmyappointment.util.BaseResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface UserService {

    BaseResponse<UserEntity> saveUserDetail(HttpServletRequest request, UserEntity user);

}
