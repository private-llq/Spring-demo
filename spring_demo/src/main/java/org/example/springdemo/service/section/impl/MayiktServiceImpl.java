package org.example.springdemo.service.section.impl;

import org.example.springdemo.service.section.MayiktService;
import org.springframework.stereotype.Component;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.service
 * @date 2022/12/11 18:02
 * @description: 公司
 */
@Component
public class MayiktServiceImpl implements MayiktService {
    @Override
    public String addUser() {
//        int a =1/0;  测试异常通知
        System.out.println("addUser...");
        return "ok";
    }

    @Override
    public String addUser(Integer age) {
        System.out.println("addUser...");
        return "ok";
    }

    @Override
    public String delUser() {
        System.out.println("delUser...");
        return "ok";
    }

    @Override
    public String updateUser() {
        System.out.println("updateUser...");
        return "ok";
    }

    @Override
    public String showUser() {
        System.out.println("showUser...");
        return "ok";
    }
}
