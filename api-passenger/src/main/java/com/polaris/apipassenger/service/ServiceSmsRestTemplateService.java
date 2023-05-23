package com.polaris.apipassenger.service;

import com.polaris.internalcommon.dto.ResponseResult;

public interface ServiceSmsRestTemplateService {
    ResponseResult sendSms(String phoneNumber, String code);
}
