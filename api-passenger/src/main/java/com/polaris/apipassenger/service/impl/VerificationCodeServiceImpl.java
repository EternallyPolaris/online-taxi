package com.polaris.apipassenger.service.impl;

import com.polaris.apipassenger.service.ServiceSmsRestTemplateService;
import com.polaris.apipassenger.service.ServiceVerificationCodeRestTemplateService;
import com.polaris.apipassenger.service.VerificationCodeService;
import com.polaris.internalcommon.constant.CommonStatusEnum;
import com.polaris.internalcommon.dto.ResponseResult;
import com.polaris.internalcommon.dto.apipassenger.request.SendRequest;
import com.polaris.internalcommon.dto.serviceverificationcode.response.VerifyCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ServiceVerificationCodeRestTemplateService serviceVerificationCodeRestTemplateService;

    @Autowired
    private ServiceSmsRestTemplateService serviceSmsRestTemplateService;

    @Override
    public ResponseResult send(String phoneNumber) {
        ResponseResult responseResult = serviceVerificationCodeRestTemplateService.generatorCode(1, phoneNumber);
        VerifyCodeResponse verifyCodeResponse = null;

        if (responseResult.getCode() == CommonStatusEnum.SUCCESS.getCode()) {
            JSONObject data = JSONObject.fromObject(responseResult.getData().toString());
            verifyCodeResponse = (VerifyCodeResponse) JSONObject.toBean(data, VerifyCodeResponse.class);
        } else {
            return ResponseResult.fail("获取验证码失败");
        }

        String code = verifyCodeResponse.getCode();

        ResponseResult result = serviceSmsRestTemplateService.sendSms(phoneNumber, code);
        if (result.getCode() != CommonStatusEnum.SUCCESS.getCode()) {
            return ResponseResult.fail("发送短信失败");
        }

        return ResponseResult.success("");
    }
}
