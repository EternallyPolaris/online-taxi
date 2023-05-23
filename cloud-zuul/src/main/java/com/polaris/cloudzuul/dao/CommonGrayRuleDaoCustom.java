package com.polaris.cloudzuul.dao;

import com.polaris.cloudzuul.entity.CommonGrayRule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonGrayRuleDaoCustom extends CommonGrayRuleDao{
    CommonGrayRule selectByUserId(Integer userId);
}
