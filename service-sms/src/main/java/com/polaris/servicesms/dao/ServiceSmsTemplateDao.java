package com.polaris.servicesms.dao;

import com.polaris.servicesms.entity.ServiceSmsTemplate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ServiceSmsTemplateDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ServiceSmsTemplate record);

    int insertSelective(ServiceSmsTemplate record);

    ServiceSmsTemplate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ServiceSmsTemplate record);

    int updateByPrimaryKey(ServiceSmsTemplate record);
}