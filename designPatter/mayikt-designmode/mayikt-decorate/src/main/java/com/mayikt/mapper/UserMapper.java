package com.mayikt.mapper;

import com.mayikt.entity.UserEntity;
import org.apache.ibatis.annotations.Select;

/**
 * @author 余胜军
 * @ClassName UserMapper
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public interface UserMapper {
    @Select("select * from users where id=#{id} ")
    UserEntity findByUser(Integer id);
}
