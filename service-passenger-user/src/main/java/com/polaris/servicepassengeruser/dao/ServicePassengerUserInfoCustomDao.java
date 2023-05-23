package com.polaris.servicepassengeruser.dao;

import com.polaris.servicepassengeruser.entity.ServicePassengerUserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ServicePassengerUserInfoCustomDao extends ServicePassengerUserInfoDao{

    /**
     * 根据手机号查询乘客信息
     * @param passengerPhone
     * @return
     */
    ServicePassengerUserInfo selectByPhoneNumber(String passengerPhone);
}