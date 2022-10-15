package com.example.springredis.controller;

import com.example.springredis.domain.Users;
import com.example.springredis.service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package com.example.springredis.controller
 * @date 2022/10/15 15:09
 * @Copyright 公司
 */
@RestController
@RequestMapping("/api")
public class Usercontroller {


    @Autowired
    private UsersService usersService;

    /**
     * 测试接口
     * @return list
     */
    @PostMapping("/get")
    public List<Users> Test(){
        List<Users> list = usersService.list();
        return list;
    }


}
