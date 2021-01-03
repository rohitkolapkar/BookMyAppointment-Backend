package com.bookmyappointment.service;


import com.bookmyappointment.entity.AppointmentEntity;
import com.bookmyappointment.util.BaseResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public interface AppointmentService {
    BaseResponse<AppointmentEntity> bookAppointment(HttpServletRequest request, AppointmentEntity appoitmentObj);

    BaseResponse<AppointmentEntity> gateAllAppointment(HttpServletRequest request, HttpServletResponse response);

    BaseResponse<AppointmentEntity> gateAppointmentDetail(HttpServletRequest request, String userType, Integer id);
}
