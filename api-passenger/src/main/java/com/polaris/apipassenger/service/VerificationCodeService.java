package com.polaris.apipassenger.service;

import com.polaris.internalcommon.dto.ResponseResult;

public interface VerificationCodeService {
    ResponseResult send(String passengerPhone);
}
