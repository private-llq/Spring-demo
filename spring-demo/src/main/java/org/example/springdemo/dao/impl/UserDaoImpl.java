package org.example.springdemo.dao.impl;

import org.example.springdemo.dao.UserDao;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.dao.impl
 * @date 2022/11/19 9:49
 * @description: 公司
 */
public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
//        System.out.println("UserDao被创建了....");
    }

    @Override
    public void add() {
        System.out.println("UserDaoImpl.......");
    }
}
