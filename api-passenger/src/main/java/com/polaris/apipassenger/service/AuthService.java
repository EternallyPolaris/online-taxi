package com.polaris.apipassenger.service;

import com.polaris.internalcommon.dto.ResponseResult;

public interface AuthService {
    public ResponseResult auth(String passengerPhone, String code);
}
