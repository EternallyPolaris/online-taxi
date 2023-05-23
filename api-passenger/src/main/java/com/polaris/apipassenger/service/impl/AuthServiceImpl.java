package com.polaris.apipassenger.service.impl;

import com.polaris.apipassenger.service.AuthService;
import com.polaris.apipassenger.service.ServicePassengerUserService;
import com.polaris.apipassenger.service.ServiceVerificationCodeRestTemplateService;
import com.polaris.internalcommon.constant.CommonStatusEnum;
import com.polaris.internalcommon.constant.IdentityConstant;
import com.polaris.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private ServiceVerificationCodeRestTemplateService serviceVerificationCodeRestTemplateService;

    @Autowired
    private ServicePassengerUserService servicePassengerUserService;

    @Override
    public ResponseResult auth(String passengerPhone, String code) {
        // 验证验证码：
        ResponseResult responseResult = serviceVerificationCodeRestTemplateService.verifyCode(IdentityConstant.PASSENGER, passengerPhone, code);
        if (responseResult.getCode() != CommonStatusEnum.SUCCESS.getCode()){
            return ResponseResult.fail("登录失败：验证码校验失败");
        }

        // 用户登录
        responseResult = servicePassengerUserService.login(passengerPhone);
        if (responseResult.getCode() != CommonStatusEnum.SUCCESS.getCode()){
            return ResponseResult.fail("登录失败：登录失败");
        }

        return responseResult;
    }

}
