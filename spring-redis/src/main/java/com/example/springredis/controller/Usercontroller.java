package com.example.springredis.controller;

import com.example.springredis.domain.Users;
import com.example.springredis.service.CaptchaBuilder;
import com.example.springredis.service.UsersService;
import com.example.springredis.util.Result;
import com.example.springredis.vo.CaptchaInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private CaptchaBuilder captchaBuilder;

    /**
     * 测试接口
     * @return list
     */
    @PostMapping("/get")
    public List<Users> Test(){
        List<Users> list = usersService.list();
        return list;
    }


    /**
     * 验证码
     * @return
     */
    @GetMapping("/insert")
    public Result captcha(){
        CaptchaInfo captchaInfo = captchaBuilder.create();
        return Result.success(captchaInfo);
    }


    /**
     * 图片验证码校验
     * @return
     */
    @PostMapping("/test")
    public Result captchaTest(@RequestParam("code") String code){
        return Result.success();
    }



}
