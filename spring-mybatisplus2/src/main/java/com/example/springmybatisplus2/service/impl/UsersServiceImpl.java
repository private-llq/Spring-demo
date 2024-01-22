package com.example.springmybatisplus2.service.impl;

import com.example.springmybatisplus2.model.Users;
import com.example.springmybatisplus2.dao.UsersMapper;
import com.example.springmybatisplus2.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户  服务实现类
 * </p>
 *
 * @author llq
 * @since 2023-12-17
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
