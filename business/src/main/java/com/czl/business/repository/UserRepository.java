package com.czl.business.repository;

import com.czl.business.entity.User;

import java.util.List;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 16:29
 */
public interface UserRepository {

    int insert (User user);

    List<User> selectAll (User user);

    User selectOne (User user);
}
