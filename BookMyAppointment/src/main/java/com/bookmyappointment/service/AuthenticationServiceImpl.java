package com.bookmyappointment.service;

import com.bookmyappointment.entity.AuthenticationEntity;
import com.bookmyappointment.entity.Notification;
import com.bookmyappointment.repository.AuthenticationRepository;
import com.bookmyappointment.util.BaseResponse;
import com.bookmyappointment.util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;


@Service
public class AuthenticationServiceImpl implements  AuthenticationService {


    @Autowired
    AuthenticationRepository repository;
    
	@Autowired
	NotificationService notificationService;

    @Override
    public BaseResponse<AuthenticationEntity> saveAuthenticationDetail(HttpServletRequest request, AuthenticationEntity authentication) {
        BaseResponse<AuthenticationEntity> baseResponse = new BaseResponse<>();
		/*
		 * String Password = generatePassword(8).toString();
		 * authentication.setPassword(Password);
		 */
        authentication = repository.save(authentication);

        baseResponse.setResponseObject(authentication);
        baseResponse.setStatus(CommonConstants.SUCCESS);
        baseResponse.setReasonText("User Added successfully");
        baseResponse.setReasonCode("200");

        return baseResponse;
    }

    @Override
    public BaseResponse<AuthenticationEntity> authenticateUser(HttpServletRequest request, AuthenticationEntity authentication) {
        BaseResponse<AuthenticationEntity> baseResponse = new BaseResponse<>();
        AuthenticationEntity authObjDB = new AuthenticationEntity();
        authObjDB = repository.findByEmail(authentication.getEmail());

        if(null != authObjDB){
            if(authObjDB.getPassword().equals(authentication.getPassword())){
                baseResponse.setResponseObject(authObjDB);
                baseResponse.setStatus(CommonConstants.SUCCESS);
                baseResponse.setReasonText("User Successfully Authenticated  ");
                baseResponse.setReasonCode("200");
            }
            else{
                baseResponse.setResponseObject(authentication);
                baseResponse.setStatus(CommonConstants.FAIL);
                baseResponse.setReasonText("UserName or Password not match");
                baseResponse.setReasonCode("400");
            }
        }
        else{
            baseResponse.setStatus(CommonConstants.FAIL);
            baseResponse.setReasonText("User Not Found  ");
            baseResponse.setReasonCode("400");
        }


        return baseResponse;
    }

    private static char[] generatePassword(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for(int i = 4; i< length ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return password;
    }

	@Override
	public BaseResponse<AuthenticationEntity> forgotPassword(HttpServletRequest request,
			AuthenticationEntity authenticationEntity) {
		BaseResponse<AuthenticationEntity> baseResponse = new BaseResponse<>();
		AuthenticationEntity authObjDB = new AuthenticationEntity();
		authObjDB = repository.findByEmail(authenticationEntity.getEmail());

		//user found
		if (null != authObjDB) {
			
				baseResponse.setResponseObject(authObjDB);
				baseResponse.setStatus(CommonConstants.SUCCESS);
				baseResponse.setReasonText("Password has been sent to registered email address.");
				baseResponse.setReasonCode("200");
				
				//send password via email
		        Notification notification = new Notification();
		        notification.setToMail(authObjDB.getEmail());
		        notification.setUserName(authObjDB.getName());
		        notification.setBccmail(CommonConstants.BCC_MAIL);
		        notification.setSubject(CommonConstants.AUTHENTICATION_FORGOT_PASSWORD_SUBJECT);
		        String MailBody = CommonConstants.AUTHENTICATION_FORGOT_PASSEORD_BODY + "Login with following Details \n\n "+ "UserName: "+authObjDB.getEmail()+"\n\n password: "+ authObjDB.getPassword()+
		        		"\n \n \n We strongly recommend you to change your password by logging into BookMyAppointment system. Thankyou.";
		        notification.setBody(MailBody);
		        notificationService.sendMail(request, notification);
		        notificationService.saveNotification(request,notification);
					
			 
		} else {
			baseResponse.setStatus(CommonConstants.FAIL);
			baseResponse.setReasonText("User Not Found");
			baseResponse.setReasonCode("400");
		}
		
		return baseResponse;

	}
}
