package com.czl.business.repository.impl;

import com.czl.business.entity.User;
import com.czl.business.mapper.UserMapper;
import com.czl.business.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 16:29
 */
@Repository ( value = "UserRepository" )
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert (User user) {
        return userMapper.insert(user);
    }
}
