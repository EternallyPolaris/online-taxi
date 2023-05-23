package com.polaris.serviceverificationcode.controller;

import com.polaris.internalcommon.dto.ResponseResult;
import com.polaris.internalcommon.dto.serviceverificationcode.request.VerifyCodeRequest;
import com.polaris.serviceverificationcode.service.VerifyCodeService;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verify-code")
@Slf4j
public class VerifyCodeController {

    @Autowired
    VerifyCodeService verifyCodeService;

    @GetMapping("/generate/{identity}/{phoneNumber}")
    public ResponseResult generate(@PathVariable("identity") int identity, @PathVariable("phoneNumber") String phoneNumber){
        log.info("/verify-code/generate/{identity}/{phoneNumber}: 身份类型: " + identity + ", 手机号: " + phoneNumber);
        // 校验参数

        return verifyCodeService.generate(identity, phoneNumber);
    }

    @PostMapping("/verify")
    public ResponseResult verify(@RequestBody VerifyCodeRequest request){
        log.info("/verify-code/verify: request: " + JSONObject.fromObject(request));
        // 获取手机号和验证码
        String phoneNumber = request.getPhoneNumber();
        int identity = request.getIdentity();
        String code = request.getCode();

        return verifyCodeService.verify(identity, phoneNumber, code);
    }
}
