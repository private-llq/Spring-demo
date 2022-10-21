package com.example.springmybatisplus.service.impl;

import com.example.springmybatisplus.model.Users;
import com.example.springmybatisplus.dao.UsersMapper;
import com.example.springmybatisplus.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户  服务实现类
 * </p>
 *
 * @author Lucas
 * @since 2022-10-21
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
