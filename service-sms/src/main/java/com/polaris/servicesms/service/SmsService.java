package com.polaris.servicesms.service;

import com.polaris.internalcommon.dto.ResponseResult;
import com.polaris.internalcommon.dto.servicesms.request.SmsSendRequest;

public interface SmsService {
    ResponseResult sendSms(SmsSendRequest smsSendRequest);
}
