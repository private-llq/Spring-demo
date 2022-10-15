package com.example.springredis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springredis.domain.Users;
import com.example.springredis.service.UsersService;
import com.example.springredis.mapper.UsersMapper;
import org.springframework.stereotype.Service;

/**
* @author liulq
* @description 针对表【users(用户 )】的数据库操作Service实现
* @createDate 2022-10-14 00:04:53
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
implements UsersService{

}
