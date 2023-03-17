package org.example.springdemo.service.mapper;

import org.example.springdemo.service.proxy.MayiktInsert;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.service.mapper
 * @date 2022/12/3 23:27
 * @description: 公司
 */
public interface UserMapper {
    @MayiktInsert("INSERT INTO `test` (`id`, `holidayDate`) VALUES (null, '2022-12-3');")
    int addUser();
}
