package com.czl.privileges.service.impl;

import com.czl.base.response.enums.ApiBaseEnum;
import com.czl.base.response.enums.ApiResponseEnum;
import com.czl.base.util.BeanCopyUtil;
import com.czl.privileges.dto.UserInsertDto;
import com.czl.privileges.entity.User;
import com.czl.privileges.repository.UserRepository;
import com.czl.privileges.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 16:37
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ApiBaseEnum insert( UserInsertDto userInsertDto) {
        User user = BeanCopyUtil.copy ( User.class , userInsertDto );
        int insert = userRepository.insert(user);
        return insert > 0 ? ApiResponseEnum.SUCCESS : ApiResponseEnum.FAIL;
    }
}
