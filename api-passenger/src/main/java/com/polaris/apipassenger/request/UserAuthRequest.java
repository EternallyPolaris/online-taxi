package com.polaris.apipassenger.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserAuthRequest {

    @NotBlank(message = "手机号不能为空")
    @Pattern(message = "手机号校验不正确",regexp = "^1(3\\d|4[5-9]|5[0-35-9]|6[567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$")
	private String passengerPhone;

    @NotBlank
    @Pattern(message = "验证码不正确",regexp = "^[0-9]{6}$")
	private String code;
}