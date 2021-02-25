package com.czl.business.service.cglib;


import org.springframework.cglib.proxy.Enhancer;

public class CglibTest {
    public static void main(String[] args) {
        LogInterceptor daoProxy = new LogInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);  // 设置超类，cglib是通过继承来实现的
        enhancer.setCallback(daoProxy);

        UserDao dao = (UserDao) enhancer.create();   // 创建代理类
        dao.update();
        dao.select();
    }
}