package com.mayikt.decorate;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.entity.UserEntity;
import com.mayikt.mapper.UserMapper;
import com.mayikt.utils.JvmMapCacheUtils;
import com.mayikt.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 余胜军
 * @ClassName MySQLDecorate
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Component
public class MySQLDecorate extends RedisDecorate implements AbstractDecorate {
    @Autowired
    private UserMapper userMapper;

    @Override
    public <T> T getCache(String key) {
        UserEntity redisUser = super.getCache(key);
        if (redisUser != null) {
            return (T) redisUser;
        }
        //如果二级缓存中没有数据 则查询我们的db
        UserEntity dbUser = userMapper.findByUser(1);
        if (dbUser != null) {
            // 将数据存放 二级、一级缓存中
            RedisUtil.setString(key, JSONObject.toJSONString(dbUser));
            JvmMapCacheUtils.putEntity(key, dbUser);
        }
        return (T) dbUser;
    }
}
