package com.polaris.apipassenger.service;

import com.polaris.internalcommon.dto.ResponseResult;

public interface ServicePassengerUserService {
    ResponseResult login(String passengerPhone);
}
