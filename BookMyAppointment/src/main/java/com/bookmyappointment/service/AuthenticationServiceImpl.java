package com.bookmyappointment.service;

import com.bookmyappointment.entity.AuthenticationEntity;
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
    CommonConstants constants;

    @Autowired
    AuthenticationRepository repository;

    @Override
    public BaseResponse<AuthenticationEntity> saveAuthenticationDetail(HttpServletRequest request, AuthenticationEntity authentication) {
        BaseResponse<AuthenticationEntity> baseResponse = new BaseResponse<>();
        String Password = generatePassword(8).toString();
        authentication.setPassword(Password);
        authentication = repository.save(authentication);

        baseResponse.setResponseObject(authentication);
        baseResponse.setStatus(CommonConstants.SUCCESS);
        baseResponse.setReasonText("User Authentication Detail Added successfully");
        baseResponse.setReasonCode("200");

        return baseResponse;
    }

    @Override
    public BaseResponse<AuthenticationEntity> AuthenticateUser(HttpServletRequest request, AuthenticationEntity authentication) {
        return null;
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
}
