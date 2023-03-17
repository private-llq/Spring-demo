package org.example.springdemo.service.impl;

import org.example.springdemo.dao.UserDao;
import org.example.springdemo.service.UserService;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.service.impl
 * @date 2022/11/19 9:50
 * @description: 公司
 */
public class UserServiceImpl implements UserService {

    //声明一个UserDao类型的变量
    private UserDao userDao;

    public UserServiceImpl() {
//        System.out.println("UserService被创建了......");
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        System.out.println("UserSerivce.........");
        userDao.add();
    }
}
