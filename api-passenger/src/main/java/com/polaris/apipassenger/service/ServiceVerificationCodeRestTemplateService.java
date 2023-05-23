package com.polaris.apipassenger.service;

import com.polaris.internalcommon.dto.ResponseResult;

public interface ServiceVerificationCodeRestTemplateService {
    ResponseResult generatorCode(int identity, String phoneNumber);

    ResponseResult verifyCode(int identity, String phoneNumber, String code);
}
