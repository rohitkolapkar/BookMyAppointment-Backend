package com.bookmyappointment.service;


import com.bookmyappointment.entity.AppointmentEntity;
import com.bookmyappointment.util.BaseResponse;
import org.springframework.stereotype.Service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public interface AppointmentService {
    BaseResponse<AppointmentEntity> bookAppointment(HttpServletRequest request, AppointmentEntity appoitmentObj);

    BaseResponse<AppointmentEntity> gateAllAppointment(HttpServletRequest request, HttpServletResponse response);

    BaseResponse<AppointmentEntity> gateAppointmentDetail(HttpServletRequest request, String userType, Integer id);

	BaseResponse<AppointmentEntity> checkAppointment(HttpServletRequest request, AppointmentEntity appoitmentObj);

	BaseResponse<AppointmentEntity> gateAllAppointmentsByConsumerId(HttpServletRequest request, int consumerId);

	BaseResponse<AppointmentEntity> putAppointment(HttpServletRequest request, AppointmentEntity appoitmentObj);

	BaseResponse<AppointmentEntity> gateAllAppointmentsBySpId(HttpServletRequest request, int spId);

	BaseResponse<AppointmentEntity> gateAllAppointmentsBySpIdDates(HttpServletRequest request, int spId,
			Date startDateTime, Date endDateTime);
}
