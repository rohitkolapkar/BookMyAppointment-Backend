package com.bookmyappointment.util;

import org.springframework.stereotype.Component;

public class CommonConstants {
	public static final String FAIL = "fail";
	public static final String SUCCESS = "success";
	public static final String PARTIAL_SUCCESS = "partial success";
	public static final String EMPTY_RESULT_SET = "EMPTY_RESULT_SET";
	public static final String RECORD_NOT_FOUND_ERROR = "Record not found";
	public static final String VALID_PARAMETER_ERROR = "Provide valid parameter";
	public static final String FROM_TO_DATE_GREATER_AND_LESS_ERROR = "Provide toDate greater than fromDate";
	public static final String FROM_TO_DATE_FORMATE_ERROR = "Provide fromDate and toDate in dd/mm/yyyy format";
	
	public static final String APPLICATION_ID = "ApplicationId";
	public static final String BU_ID = "Buid";
	public static final String SUBBU_ID = "SubBuId";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String ENVIORMENT = "Environment";
	
	public static final String USER_LOGIN = "userlogin";
	public static final String ISSUER = "issuer";
	public static final String USERID = "userId";
	
	
	public static final String TOKEN = "token";
	public static final String JTITOKEN = "jtitoken";
	
	public static final String SYSTEM_ERROR = "System error occured, we could not process this request";
	
	public static final String AUDIT_ACTION_BY_ID = "1"; 
	
	public static final String LOG_EVENT_NAME = "Log Management";
	public static final String LOG_MODULE_NAME = "Log";
	
	public static final String SAVE_LOG_ENTITY_NAME = "ADD";
	public static final String SAVE_LOG_ENTITY_ACTION_NAME = "Save Log";
	
	public static final String GET_LOG_ENTITY_NAME = "GET";
	public static final String GET_LOG_ENTITY_ACTION_NAME = "Get Log";
	
	
	public static final String FROM_DATE_GT_TO_DATE = "From date is greater than To date please provide proper date";
	
	public static final String FROM_DATE_GT_CURRENT_DATE = "From date is greater than current date please provide proper date";
	
	public static final String TO_DATE_GT_CURRENT_DATE = "To date is greater than current date please provide proper date";
	
	public static final String FILE_NOT_FOUND = "File not found";
	
	public static final String BCC_MAIL = null;
	
	public static final String BUSINESS_REGISTRATION_SUBJECT = "Business Registration Successful";
	public static final String BUSINESS_REGISTRATION_BODY = "Thank You for regestering your business with us.";
	
	public static final String CUSTOMER_REGISTRATION_SUBJECT = "Registration Successful";
	public static final String CUSTOMER_REGISTRATION_BODY = "Thank You for regestering with us.";
	
	public static final String AUTHENTICATION_FORGOT_PASSWORD_SUBJECT = "Forget Password";
	public static final String AUTHENTICATION_FORGOT_PASSEORD_BODY = "Hello BookMyAppointment User,\n";

		
	public static final String APPLICATIONID_FCADMIN = "11155";
}
