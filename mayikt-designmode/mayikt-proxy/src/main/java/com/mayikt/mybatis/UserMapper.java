package com.mayikt.mybatis;

import com.mayikt.mybatis.ext.MayiktInsert;
import org.springframework.stereotype.Component;

/**
 * @author 余胜军
 * @ClassName UserMapper
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Component
public interface UserMapper {
    @MayiktInsert("INSERT INTO `mayikt`.`mayikt_users` (`id`, `name`, `age`) VALUES (null, 'wangmazi', NULL);")
    int addUser();
}
