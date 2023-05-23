package com.polaris.servicesms.dao;

import com.polaris.servicesms.entity.ServiceSmsRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ServiceSmsRecordDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ServiceSmsRecord record);

    int insertSelective(ServiceSmsRecord record);

    ServiceSmsRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ServiceSmsRecord record);

    int updateByPrimaryKey(ServiceSmsRecord record);
}