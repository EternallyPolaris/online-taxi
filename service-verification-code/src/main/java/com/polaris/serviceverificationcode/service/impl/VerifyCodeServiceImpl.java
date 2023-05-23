package com.polaris.serviceverificationcode.service.impl;


import com.polaris.internalcommon.constant.CommonStatusEnum;
import com.polaris.internalcommon.constant.IdentityConstant;
import com.polaris.internalcommon.constant.RedisKeyPrefixConstant;
import com.polaris.internalcommon.dto.ResponseResult;
import com.polaris.internalcommon.dto.serviceverificationcode.response.VerifyCodeResponse;
import com.polaris.serviceverificationcode.service.VerifyCodeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public ResponseResult<VerifyCodeResponse> generate(int identity, String phoneNumber) {
        // 校验 三档验证。 乌云 安全检测。 业务方控制，不能无限制发短信
        // redis 1分钟发了3次，限制5分钟不能发。1小时发了10次，限制24小时内不能发。

        String code = String.valueOf((int) ((Math.random() * 9 + 1) * Math.pow(10, 5)));

        String keyPre = generateKeyPreByIdentity(identity);
        String key = keyPre + phoneNumber;
//        BoundValueOperations codeRedis = redisTemplate.boundValueOps(key);
//
//        codeRedis.set(key);
//        codeRedis.expire(5, TimeUnit.MINUTES);

        redisTemplate.opsForValue().set(key, code, 5, TimeUnit.MINUTES);

        VerifyCodeResponse result = new VerifyCodeResponse();
        result.setCode(code);
        return ResponseResult.success(result);
    }

    /**
     * 用户传进来的验证码 和 Redis 中验证码一致，校验通过，否则不通过。
     * @param identity
     * @param phoneNumber
     * @param code
     * @return
     */
    @Override
    public ResponseResult verify(int identity, String phoneNumber, String code) {
        // 三档验证
        
        // 生成redis key
        String keyPre = generateKeyPreByIdentity(identity);
        String key = keyPre + phoneNumber;

        String codeRedis = (String) redisTemplate.opsForValue().get(key);

        if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(codeRedis) && code.trim().equals(codeRedis.trim())) {
            return ResponseResult.success("");
        } else {
            return ResponseResult.fail(CommonStatusEnum.VERIFY_CODE_ERROR.getCode(), CommonStatusEnum.VERIFY_CODE_ERROR.getValue());
        }
    }

    /**
     * 判断此手机号发送时限限制
     * @param phoneNumber
     * @return
     */
    private ResponseResult checkSendCodeTimeLimit(String phoneNumber) {
        // 判断是否有 限制1分钟，10分钟，24小时

        return ResponseResult.success("");
    }

    /**
     * 根据身份类型生成对应的缓存key
     * @param identity
     * @return
     */
    private String generateKeyPreByIdentity(int identity) {
        String keyPre = "";
        if (identity == IdentityConstant.PASSENGER) {
            keyPre = RedisKeyPrefixConstant.PASSENGER_LOGIN_CODE_KEY_PRE;
        } else if (identity == IdentityConstant.DRIVER) {
            keyPre = RedisKeyPrefixConstant.DRIVER_LOGIN_CODE_KEY_PRE;
        }
        return keyPre;
    }

    /**
     * 三档验证校验
     * @param phoneNumber
     * @param code
     * @return
     */
    private ResponseResult checkCodeThreeLimit(String phoneNumber, String code) {
        // 看流程图


        return ResponseResult.success("");
    }
}
