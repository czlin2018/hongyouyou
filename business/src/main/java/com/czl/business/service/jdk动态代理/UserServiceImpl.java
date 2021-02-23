package com.czl.business.service.jdk动态代理;

/**
 * @author czlin
 * @date 2021-02-23 10:09
 */
public class UserServiceImpl implements UserService {
    @Override
    public void select() {
        System.out.println("select");
    }

    @Override
    public void update() {
        System.out.println("update");
    }
}
