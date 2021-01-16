package com.bookmyappointment.service;

import com.bookmyappointment.entity.AppointmentEntity;
import com.bookmyappointment.entity.ServiceProviderEntity;
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
    public BaseResponse<AppointmentEntity> bookAppointment(HttpServletRequest request, AppointmentEntity appointmentObj) {
        BaseResponse<AppointmentEntity> baseResponse = new BaseResponse<>();

        //First Check Appointment is present or not
        Boolean result = CheckAppointmentExists(appointmentObj.getServiceProvider().getSpId(),appointmentObj.getStartDateTime(),appointmentObj.getEndDateTime());
       if(result){
           baseResponse.setStatus(CommonConstants.FAIL);
           baseResponse.setReasonText("Time Slot Already Exists");
           baseResponse.setReasonCode("400");

       }else{
           appointmentObj = repository.save(appointmentObj);
           baseResponse.setResponseObject(appointmentObj);
           baseResponse.setStatus(CommonConstants.SUCCESS);
           baseResponse.setReasonText("appoitment Added successfully");
           baseResponse.setReasonCode("200");
       }


        return baseResponse;
    }

    //function to check appointment exist or not
    private Boolean CheckAppointmentExists(Integer spId, Date startDateTime, Date endDateTime) {
        /*List<AppointmentEntity> appointment =
                repository.findByServiceProvider_SpIdAndStartDateTimeGreaterThanEqualOrEndDateTimeLessThanEqual(spId,startDateTime,endDateTime);
*/
        List<AppointmentEntity> appointment = repository.customQuery (spId,startDateTime,endDateTime);
        if(appointment.size()!=0){
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

    @Override
    public BaseResponse<AppointmentEntity> gateAppointmentDetail(HttpServletRequest request, String userType, Integer id) {
        BaseResponse<AppointmentEntity> baseResponse = new BaseResponse<>();
        List<AppointmentEntity> entity = null;
        if(userType.equals("sp")){
            entity= repository.findByServiceProvider_SpId(id);
        }
        else if(userType.equals("user")){
            entity= repository.findByconsumer_Id(id);
        }
        baseResponse.setResponseListObject(entity);
        baseResponse.setStatus(CommonConstants.SUCCESS);
        baseResponse.setReasonText("List of Appointments");
        baseResponse.setReasonCode("200");
        return baseResponse;
    }

	@Override
	public BaseResponse<AppointmentEntity> checkAppointment(HttpServletRequest request,
			AppointmentEntity appoitmentObj) {
		BaseResponse<AppointmentEntity> baseResponse = new BaseResponse<>();
		//First Check Appointment is present or not
        Boolean result = CheckAppointmentExists(appoitmentObj.getServiceProvider().getSpId(),appoitmentObj.getStartDateTime(),appoitmentObj.getEndDateTime());
        if(result){
            baseResponse.setStatus(CommonConstants.FAIL);
            baseResponse.setReasonText("Time Slot Already Exists");
            baseResponse.setReasonCode("400");

        }else{
            baseResponse.setResponseObject(appoitmentObj);
            baseResponse.setStatus(CommonConstants.SUCCESS);
            baseResponse.setReasonText("Time Slot Available");
            baseResponse.setReasonCode("200");
        }
		return baseResponse;
	}

	@Override
	public BaseResponse<AppointmentEntity> gateAllAppointmentsByConsumerId(HttpServletRequest request, int consumerId) {
		
		BaseResponse<AppointmentEntity> baseResponse = new BaseResponse<>();
        List<AppointmentEntity> entity = repository.findAll();
     
		entity = repository.findByConsumer_IdOrderByStartDateTimeDesc(consumerId);
		
		baseResponse.setResponseListObject(entity);
		baseResponse.setStatus(CommonConstants.SUCCESS);
		baseResponse.setReasonText("find All Appointments by consumer id");
		baseResponse.setReasonCode("200");
		return baseResponse;
	}

	//pending
	@Override
	public BaseResponse<AppointmentEntity> putAppointment(HttpServletRequest request, AppointmentEntity appoitmentObj) {
		BaseResponse<AppointmentEntity> baseResponse = new BaseResponse<>();
		AppointmentEntity entity=repository.save(appoitmentObj);
        baseResponse.setResponseObject(entity);
        baseResponse.setStatus(CommonConstants.SUCCESS);
        baseResponse.setReasonText("List of Appointments");
        baseResponse.setReasonCode("200");
        return baseResponse;
		
	}

	@Override
	public BaseResponse<AppointmentEntity> gateAllAppointmentsBySpId(HttpServletRequest request, int spId) {
		BaseResponse<AppointmentEntity> baseResponse = new BaseResponse<>();
        List<AppointmentEntity> entity = repository.findByServiceProvider_SpIdOrderByStartDateTimeDesc(spId);	
		baseResponse.setResponseListObject(entity);
		baseResponse.setStatus(CommonConstants.SUCCESS);
		baseResponse.setReasonText("find All Appointments by consumer id");
		baseResponse.setReasonCode("200");
		return baseResponse;
	}

	@Override
	public BaseResponse<AppointmentEntity> gateAllAppointmentsBySpIdDates(HttpServletRequest request, int spId,
			Date startDateTime, Date endDateTime) {
		
		BaseResponse<AppointmentEntity> baseResponse = new BaseResponse<>();
        List<AppointmentEntity> entity = 
        		 repository.findByServiceProvider_SpIdAndStartDateTimeGreaterThanEqualAndEndDateTimeLessThanEqual(spId,startDateTime,endDateTime);
        System.out.println(entity);
		baseResponse.setResponseListObject(entity);
		baseResponse.setStatus(CommonConstants.SUCCESS);
		baseResponse.setReasonText("find All Appointments by consumer id");
		baseResponse.setReasonCode("200");
		return baseResponse;
		
	}
}
