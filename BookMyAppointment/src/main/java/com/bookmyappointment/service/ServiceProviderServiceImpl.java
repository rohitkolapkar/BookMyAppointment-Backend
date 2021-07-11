package com.bookmyappointment.service;

import com.bookmyappointment.controller.NotificationContoller;
import com.bookmyappointment.entity.AuthenticationEntity;
import com.bookmyappointment.entity.CityEntity;
import com.bookmyappointment.entity.ServiceProviderEntity;
import com.bookmyappointment.entity.Notification;
import com.bookmyappointment.entity.ServiceCategoryEntity;
import com.bookmyappointment.util.BaseResponse;
import com.bookmyappointment.util.CommonConstants;
import com.bookmyappointment.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

	@Autowired
	ServiceProviderRepository spRepository;

	@Autowired
	AuthenticationService authService;

	@Autowired
	NotificationContoller notificationContoller;

	public BaseResponse<ServiceProviderEntity> saveServiceProvider(HttpServletRequest request,
			ServiceProviderEntity business) {
		BaseResponse<ServiceProviderEntity> baseResponse = new BaseResponse<>();

		Boolean UserExists = authService.CheckUserExists(business.getSpEmail());
		if(UserExists){
			//if user is already present in system return error
			baseResponse.setStatus(CommonConstants.FAIL);
			baseResponse.setReasonText("You have already registered with us. Please try to log in");
			baseResponse.setReasonCode("400");

			return baseResponse;

		}else {

			business = spRepository.save(business);
			BaseResponse<AuthenticationEntity> authentication = new BaseResponse<>();
			AuthenticationEntity authenticationEntity = new AuthenticationEntity();

			authenticationEntity.setName(business.getSpName());
			authenticationEntity.setEmail(business.getSpEmail());
			authenticationEntity.setMobile(business.getSpPhone());
			authenticationEntity.setPassword(business.getSpPassword());
			authenticationEntity.setActive(true);
			authenticationEntity.setRole("serviceProvider");
			authenticationEntity.setSpId(business.getSpId());
			authentication = authService.saveAuthenticationDetail(request, authenticationEntity);

			// Send Mail

			Notification notification = new Notification();
			notification.setToMail(business.getSpEmail());
			notification.setUserName(business.getBusinessName());
			notification.setBccmail(CommonConstants.BCC_MAIL);
			notification.setSubject(CommonConstants.BUSINESS_REGISTRATION_SUBJECT);
			String MailBody = CommonConstants.BUSINESS_REGISTRATION_BODY +
					"Login with following Detail \n\n " +
					"UserName: " + authentication.getResponseObject().getEmail() + "\n\n password: " +
					authentication.getResponseObject().getPassword();
			notification.setBody(MailBody);
			notificationContoller.saveNotification(request, notification);

			// Set BaseResponse
			baseResponse.setResponseObject(business);
			baseResponse.setStatus(CommonConstants.SUCCESS);
			baseResponse.setReasonText("Business Added successfully");
			baseResponse.setReasonCode("200");

			return baseResponse;
		}
	}

	@Override
	public BaseResponse<ServiceProviderEntity> gateAllServiceProvider(HttpServletRequest request, String cityName) {

		BaseResponse<ServiceProviderEntity> baseResponse = new BaseResponse<>();
		List<ServiceProviderEntity> entity = null;
		if(cityName.equals("all")){
			entity = spRepository.findAll();}
		else{
			entity = spRepository.findByCity_CityName(cityName);
		}
		baseResponse.setResponseListObject(entity);
		baseResponse.setStatus(CommonConstants.SUCCESS);
		baseResponse.setReasonText("find All city");
		baseResponse.setReasonCode("200");
		return baseResponse;
	}

	@Override
	public BaseResponse<ServiceProviderEntity> gateAllServiceProviderByCityCategory(HttpServletRequest request,
			int cityId, int categoryId) {
		
		BaseResponse<ServiceProviderEntity> baseResponse = new BaseResponse<>();
		List<ServiceProviderEntity> entity = null;
		
			entity = spRepository.findByCity_CityIdAndServiceCategory_CategoryId(cityId,categoryId);
		
		baseResponse.setResponseListObject(entity);
		baseResponse.setStatus(CommonConstants.SUCCESS);
		baseResponse.setReasonText("find All Service Providers by City and Category");
		baseResponse.setReasonCode("200");
		return baseResponse;
		
	}

}
