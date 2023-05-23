package com.polaris.apipassenger.service.impl;

import com.polaris.apipassenger.service.ServicePassengerUserService;
import com.polaris.internalcommon.dto.ResponseResult;
import com.polaris.internalcommon.dto.apipassenger.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServicePassengerUserServiceImpl implements ServicePassengerUserService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseResult login(String passengerPhone) {
        String url = "http://service-passenger-user/auth/login";

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassengerPhone(passengerPhone);
        ResponseResult result = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<Object>(loginRequest,null), ResponseResult.class).getBody();
//        ResponseResult result = restTemplate.postForObject(url, loginRequest, ResponseResult.class);
        return result;
    }
}
