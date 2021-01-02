package com.bookmyappointment.controller;

import com.bookmyappointment.entity.AppointmentEntity;
import com.bookmyappointment.service.AppointmentService;
import com.bookmyappointment.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/v1/appotment")
public class AppointmentController {

    @Autowired
    AppointmentService service;

    @PostMapping()
    public ResponseEntity<BaseResponse<AppointmentEntity>> bookAppointment(HttpServletRequest request,
                                                                           @RequestBody AppointmentEntity appoitmentObj) {

        BaseResponse<AppointmentEntity> appointmentResponse  = service.bookAppointment(request, appoitmentObj);
        ResponseEntity<BaseResponse<AppointmentEntity>> response = new ResponseEntity<BaseResponse<AppointmentEntity>>(appointmentResponse, null, HttpStatus.OK);
        return response;

    }

    @GetMapping()
    public ResponseEntity<BaseResponse<AppointmentEntity>> getAllAppointment(HttpServletRequest request,
                                                                             HttpServletResponse response) {
        ResponseEntity<BaseResponse<AppointmentEntity>> Response = null;
        BaseResponse<AppointmentEntity> appointmentResponse = service.gateAllAppointment(request,response);
        Response = new ResponseEntity<BaseResponse<AppointmentEntity>>(appointmentResponse, null, HttpStatus.OK);
        return Response;
    }
}
