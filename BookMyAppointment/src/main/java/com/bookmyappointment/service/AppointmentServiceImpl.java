package com.bookmyappointment.service;

import com.bookmyappointment.entity.AppointmentEntity;
import com.bookmyappointment.repository.AppointmentRepository;
import com.bookmyappointment.util.BaseResponse;
import com.bookmyappointment.util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentRepository repository;
    @Override
    public BaseResponse<AppointmentEntity> bookAppointment(HttpServletRequest request, AppointmentEntity appoitmentObj) {
        BaseResponse<AppointmentEntity> baseResponse = new BaseResponse<>();

        //First Check Appointment is present or not
        Boolean result = CheckAppointmentExists(appoitmentObj.getServiceProvider().getSpId(),appoitmentObj.getStartDateTime(),appoitmentObj.getEndDateTime());
       if(result){
           baseResponse.setStatus(CommonConstants.FAIL);
           baseResponse.setReasonText("Time Slot Already Exists");
           baseResponse.setReasonCode("400");

       }else{
           appoitmentObj = repository.save(appoitmentObj);
           baseResponse.setResponseObject(appoitmentObj);
           baseResponse.setStatus(CommonConstants.SUCCESS);
           baseResponse.setReasonText("appoitment Added successfully");
           baseResponse.setReasonCode("200");
       }


        return baseResponse;
    }

    private Boolean CheckAppointmentExists(Integer spId, Date startDateTime, Date endDateTime) {
        AppointmentEntity appointment =
                repository.findByServiceProvider_SpIdAndStartDateTimeGreaterThanEqualAndEndDateTimeLessThan(spId,startDateTime,endDateTime);

        if(null != appointment){
            return true;
        }
        else{
        return false;}

    }

    @Override
    public BaseResponse<AppointmentEntity> gateAllAppointment(HttpServletRequest request, HttpServletResponse response) {

        BaseResponse<AppointmentEntity> baseResponse = new BaseResponse<>();
        List<AppointmentEntity> entity = repository.findAll();
        baseResponse.setResponseListObject(entity);
        baseResponse.setStatus(CommonConstants.SUCCESS);
        baseResponse.setReasonText("List of Appointments");
        baseResponse.setReasonCode("200");
        return baseResponse;
    }
}
