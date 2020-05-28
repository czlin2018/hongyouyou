package com.czl.business.service.impl;

import com.czl.base.response.enums.ApiBaseEnum;
import com.czl.base.response.enums.ApiResponseEnum;
import com.czl.business.entity.User;
import com.czl.business.repository.UserRepository;
import com.czl.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 16:37
 */
@Service ( value = "userService" )
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ApiBaseEnum insert () {
        User user = new User();
        user.setUserId(1l);
        user.setUserName("2");
        int insert = userRepository.insert(user);
        return insert > 0 ? ApiResponseEnum.SUCCESS : ApiResponseEnum.FAIL;
    }
}
