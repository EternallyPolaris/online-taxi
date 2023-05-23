package com.polaris.apipassenger.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class ShortMsgRequest {

    /**
     * 自定义 校验手机号的注解
     */
//    @PhoneNumberValidation

    /**
     * 通过 正则校验
     */
    @NotNull(message = "手机号不能为空")
    @Pattern(message = "手机号校验不正确", regexp = "^1(3\\d|4[5-9]|5[0-35-9]|6[567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$")
    private String phoneNumber;
}
