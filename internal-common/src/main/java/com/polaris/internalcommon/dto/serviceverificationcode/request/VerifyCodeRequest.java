package com.polaris.internalcommon.dto.serviceverificationcode.request;

import lombok.Data;

@Data
public class VerifyCodeRequest {
    int identity;
    String code;
    String phoneNumber;
}
