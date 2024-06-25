package com.example.springmybatisplus2.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.springmybatisplus2.model.Users;
import com.example.springmybatisplus2.service.IUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.dnd.DropTargetEvent;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户  前端控制器
 * </p>
 *
 * @author llq
 * @since 2023-12-17
 */
@RestController
@RequestMapping("/springmybatisplus2/users")
@Slf4j
public class UsersController {


    @Autowired
    private IUsersService usersService;

    @GetMapping("/get")
    public Users get(){
        return usersService.getOne(null);
    }

    @PostMapping("/list")
    public List<Users> getlist(){
        return usersService.list(null);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam(value = "id",required = false) String id){
        return usersService.removeById(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Users users){
        log.info("修改用户信息：{}",users);
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",users.getUserId());
        return usersService.update(users,wrapper);
    }

    @PostMapping("/page")
    public boolean page(@RequestBody Users users){
        log.info("修改用户信息：{}",users);
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",users.getUserId());
        return usersService.update(users,wrapper);
    }

}

