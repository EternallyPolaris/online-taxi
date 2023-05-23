package com.polaris.servicepassengeruser.service;

import com.polaris.internalcommon.dto.ResponseResult;

public interface PassengerUserService {

    public ResponseResult login(String passengerPhone);

    public ResponseResult logout(String token);
}
