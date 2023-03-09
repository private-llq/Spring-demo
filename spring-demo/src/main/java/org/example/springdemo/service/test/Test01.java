package org.example.springdemo.service.test;

import org.example.springdemo.service.mapper.MapperProxy;
import org.example.springdemo.service.mapper.UserMapper;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.service.test
 * @date 2022/12/3 23:31
 * @description: 公司
 */
public class Test01 {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserMapper userMapper = MapperProxy.getUserMapper(UserMapper.class);
        int result = userMapper.addUser();
        System.out.println(result);
    }
}
