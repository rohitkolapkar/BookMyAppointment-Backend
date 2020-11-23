package com.bookmyappointment.util;

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
	
	// Institute Constant
	public static final String PRODUCT_EVENT_NAME = "Product Controller";
	public static final String PRODUCT_MODULE_NAME = "Product";

	public static final String GET_PRODUCT_ENTITY_NAME = "GET";
	public static final String GET_PRODUCT_ENTITY_ACTION_NAME = "Get Product";

	public static final String SAVE_PRODUCT_ENTITY_NAME = "ADD";
	public static final String SAVE_PRODUCT_ENTITY_ACTION_NAME = "Save Product or Bulk Product";

	public static final String UPDATE_PRODUCT_ENTITY_NAME = "UPDATE";
	public static final String UPDATE_PRODUCT_ENTITY_ACTION_NAME = "Update Product";

	public static final String DELETE_PRODUCT_ENTITY_NAME = "DELETE";
	public static final String DELETE_PRODUCT_ENTITY_ACTION_NAME = "Delete Product";
	
	
	public static final String INSTITUTE_EVENT_NAME = "Institute Controller";
	public static final String INSTITUTE_MODULE_NAME = "Institute";

	public static final String GET_INSTITUTE_ENTITY_NAME = "GET";
	public static final String GET_INSTITUTE_ENTITY_ACTION_NAME = "Get Institute";

	public static final String SAVE_INSTITUTE_ENTITY_NAME = "ADD";
	public static final String SAVE_INSTITUTE_ENTITY_ACTION_NAME = "Save Single or Bulk Party";

	public static final String UPDATE_INSTITUTE_ENTITY_NAME = "UPDATE";
	public static final String UPDATE_INSTITUTE_ENTITY_ACTION_NAME = "Update Institute";

	public static final String DELETE_INSTITUTE_ENTITY_NAME = "DELETE";
	public static final String DELETE_INSTITUTE_ENTITY_ACTION_NAME = "Delete Institute";
	
	public static final String ENQUIRY_EVENT_NAME = "StudentEnquiryController";
	public static final String ENQUIRY_MODULE_NAME = "StudentEnquiry";
	public static final String SAVE_ENQUIRY_ENTITY_ACTION_NAME = "ADD";
	public static final String SAVE_ENQUIRY_ENTITY_NAME = "Save Enquiry";
	public static final String GET_ENQUIRY_ENTITY_NAME = "GET";
	public static final String GET_ENQUIRY_ENTITY_ACTION_NAME ="Get Enquiry";
	
	
	//User 
	public static final String ADMIN_EVENT_NAME = "Admin User controller";
	public static final String ADMIN_MODULE_NAME = "Admin";

	public static final String GET_ADMIN_EVENT_NAME = "GET";
	public static final String GET_ADMIN_ENTITY_ACTION_NAME = "Get User";

	public static final String SAVE_ADMIN_ENTITY_NAME = "ADD";
	public static final String SAVE_ADMIN_ENTITY_ACTION_NAME = "Save User";

	public static final String UPDATE_ADMIN_ENTITY_NAME = "UPDATE";
	public static final String UPDATE_ADMIN_ENTITY_ACTION_NAME = "Update User";

	public static final String DELETE_ADMIN_ENTITY_NAME = "DELETE";
	public static final String DELETE_ADMIN_ENTITY_ACTION_NAME = "Delete User";
		
	public static final String APPLICATIONID_FCADMIN = "11155";
}
