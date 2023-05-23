package com.polaris.serviceverificationcode.service;

import com.polaris.internalcommon.dto.ResponseResult;
import com.polaris.internalcommon.dto.serviceverificationcode.response.VerifyCodeResponse;

public interface VerifyCodeService {
    ResponseResult<VerifyCodeResponse> generate(int identity, String phoneNumber);
    ResponseResult verify(int identity, String phoneNumber, String code);
}
