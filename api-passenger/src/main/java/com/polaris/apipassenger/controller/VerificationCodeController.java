package com.polaris.apipassenger.controller;

import com.polaris.apipassenger.request.ShortMsgRequest;
import com.polaris.apipassenger.service.VerificationCodeService;
import com.polaris.internalcommon.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verify-code")
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    @RequestMapping("/send")
    public ResponseResult send(@RequestBody @Validated ShortMsgRequest request) {
        return verificationCodeService.send(request.getPhoneNumber());
    }
}
