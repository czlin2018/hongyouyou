package com.czl.business.service.impl;

import com.czl.base.response.enums.ApiBaseEnum;
import com.czl.base.response.enums.ApiResponseEnum;
import com.czl.business.entity.User;
import com.czl.business.repository.UserRepository;
import com.czl.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    @Transactional ( rollbackFor = Exception.class )
    public ApiBaseEnum insert () {
        int insert = insertDb();
        selectDb();
        int i = 1 / 0;
        return insert > 0 ? ApiResponseEnum.SUCCESS : ApiResponseEnum.FAIL;
    }

    public int insertDb () {
        int success = 0;
        List<User> userList = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++) {
            User user = new User();
            user.setUserId(Long.valueOf(i));
            user.setUserName("user" + i);
            userList.add(user);
        }
        for (User user : userList) {
            System.out.println(user.getId());
            int insert = userRepository.insert(user);
            System.out.println(user.getId());
            selectDb(user);
            success += insert;
        }
        return success;
    }

    public void selectDb () {
        for (User user : userRepository.selectAll(null)) {
            System.out.println(user.getUserName());
        }
    }

    public void selectDb (User user) {
        System.out.println(userRepository.selectOne(user).getUserName());
    }


}
