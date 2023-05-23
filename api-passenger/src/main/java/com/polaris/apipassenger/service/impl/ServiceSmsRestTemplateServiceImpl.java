package com.polaris.apipassenger.service.impl;

import com.polaris.apipassenger.service.ServiceSmsRestTemplateService;
import com.polaris.internalcommon.dto.ResponseResult;
import com.polaris.internalcommon.dto.servicesms.SmsTemplateDto;
import com.polaris.internalcommon.dto.servicesms.request.SmsSendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ServiceSmsRestTemplateServiceImpl implements ServiceSmsRestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseResult sendSms(String phoneNumber, String code) {
        String url = "http://service-sms/send/sms-template";

        SmsSendRequest smsSendRequest = new SmsSendRequest();
        String[] phoneNumbers = new String[] {phoneNumber};
        smsSendRequest.setReceivers(phoneNumbers);

        List<SmsTemplateDto> data = new ArrayList<>();
        SmsTemplateDto dto = new SmsTemplateDto();
        dto.setId("SMS_144145499");
        int templateSize = 1;
        HashMap<String, Object> templateMap = new HashMap<>(templateSize);
        templateMap.put("code", code);
        dto.setTemplateMap(templateMap);
        data.add(dto);

        smsSendRequest.setData(data);

        return restTemplate.postForEntity(url, smsSendRequest, ResponseResult.class).getBody();
    }

    public static void main(String[] args) {
        String phoneNumber = "17625967296";
        String[] phoneNumbers = new String[] {phoneNumber};
        for (String a :phoneNumbers) {
            System.out.println(a.toString());
        }
    }
}
