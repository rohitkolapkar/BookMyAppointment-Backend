package com.bookmyappointment.controller;

import com.bookmyappointment.entity.AppointmentEntity;
import com.bookmyappointment.service.AppointmentService;
import com.bookmyappointment.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/v1/appointment")
public class AppointmentController {
	DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"); 

	@Autowired
	AppointmentService service;

	@PostMapping()
	public ResponseEntity<BaseResponse<AppointmentEntity>> bookAppointment(HttpServletRequest request,
			@RequestBody AppointmentEntity appoitmentObj) {

		BaseResponse<AppointmentEntity> appointmentResponse = service.bookAppointment(request, appoitmentObj);
		ResponseEntity<BaseResponse<AppointmentEntity>> response = new ResponseEntity<BaseResponse<AppointmentEntity>>(
				appointmentResponse, null, HttpStatus.OK);
		return response;

	}
	//pending
	@PutMapping(path="/updateStatus")
	public ResponseEntity<BaseResponse<AppointmentEntity>> updateAppointment(HttpServletRequest request,
			@RequestBody AppointmentEntity appoitmentObj) {

		BaseResponse<AppointmentEntity> appointmentResponse = service.putAppointment(request, appoitmentObj);
		ResponseEntity<BaseResponse<AppointmentEntity>> response = new ResponseEntity<BaseResponse<AppointmentEntity>>(
				appointmentResponse, null, HttpStatus.OK);
		return response;

	}

	@PostMapping(path = "/check")
	public ResponseEntity<BaseResponse<AppointmentEntity>> checkAppointment(HttpServletRequest request,
			@RequestBody AppointmentEntity appoitmentObj) {

		BaseResponse<AppointmentEntity> appointmentResponse = service.checkAppointment(request, appoitmentObj);
		ResponseEntity<BaseResponse<AppointmentEntity>> response = new ResponseEntity<BaseResponse<AppointmentEntity>>(
				appointmentResponse, null, HttpStatus.OK);
		return response;

	}

	@GetMapping()
	public ResponseEntity<BaseResponse<AppointmentEntity>> getAllAppointment(HttpServletRequest request,
			HttpServletResponse response) {
		ResponseEntity<BaseResponse<AppointmentEntity>> Response = null;
		BaseResponse<AppointmentEntity> appointmentResponse = service.gateAllAppointment(request, response);
		Response = new ResponseEntity<BaseResponse<AppointmentEntity>>(appointmentResponse, null, HttpStatus.OK);
		return Response;
	}

	@GetMapping(path = "/{userType}/{userId}")
	public ResponseEntity<BaseResponse<AppointmentEntity>> getAppointmentDetails(HttpServletRequest request,
			@PathVariable("userType") String userType, @PathVariable("userId") Integer id) {

		BaseResponse<AppointmentEntity> appointmentResponse = service.gateAppointmentDetail(request, userType, id);
		ResponseEntity<BaseResponse<AppointmentEntity>> response = new ResponseEntity<BaseResponse<AppointmentEntity>>(
				appointmentResponse, null, HttpStatus.OK);
		return response;
	}
	
	@GetMapping(path="/getAppointmentsByconsumerId")
	public ResponseEntity<BaseResponse<AppointmentEntity>> getAppointmentsByConsumerId(HttpServletRequest request,
			@RequestParam("consumerId") int consumerId) {
		ResponseEntity<BaseResponse<AppointmentEntity>> Response = null;
		BaseResponse<AppointmentEntity> appointmentResponse = service.gateAllAppointmentsByConsumerId(request, consumerId);
		Response = new ResponseEntity<BaseResponse<AppointmentEntity>>(appointmentResponse, null, HttpStatus.OK);
		return Response;
	}
	
	@GetMapping(path="/getAppointmentsBySpId")
	public ResponseEntity<BaseResponse<AppointmentEntity>> getAppointmentsBySpId(HttpServletRequest request,
			@RequestParam("spId") int spId) {
		ResponseEntity<BaseResponse<AppointmentEntity>> Response = null;
		BaseResponse<AppointmentEntity> appointmentResponse = service.gateAllAppointmentsBySpId(request, spId);
		Response = new ResponseEntity<BaseResponse<AppointmentEntity>>(appointmentResponse, null, HttpStatus.OK);
		return Response;
	}
	
	@GetMapping(path="/getAppointmentsBySpIdDates")
	public ResponseEntity<BaseResponse<AppointmentEntity>> getAppointmentsBySpIdDates(HttpServletRequest request,
			@RequestParam("spId") int spId,@RequestParam("s") String startDateTimeString,@RequestParam("e") String endDateTimeString) {
		
		Date startDateTime=null;
		Date endDateTime=null;
		
		try {
			startDateTime = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(startDateTimeString);
			endDateTime=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(endDateTimeString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(spId+" "+startDateTime+" "+endDateTime+" ");
		ResponseEntity<BaseResponse<AppointmentEntity>> Response = null;
		BaseResponse<AppointmentEntity> appointmentResponse = service.gateAllAppointmentsBySpIdDates(request, spId,startDateTime,endDateTime);
		Response = new ResponseEntity<BaseResponse<AppointmentEntity>>(appointmentResponse, null, HttpStatus.OK);
		return Response;
	}
	
}
