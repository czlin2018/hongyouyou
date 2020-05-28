package com.czl.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.czl.business.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @描述: 
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 16:28
 */
@Mapper()
public interface UserMapper extends BaseMapper<User> {
}