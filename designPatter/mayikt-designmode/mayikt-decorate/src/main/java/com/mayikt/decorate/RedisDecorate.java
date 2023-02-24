package com.mayikt.decorate;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.entity.UserEntity;
import com.mayikt.utils.JvmMapCacheUtils;
import com.mayikt.utils.RedisUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author 余胜军
 * @ClassName RedisDecorate
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Component
public class RedisDecorate extends JvmComponentCache implements AbstractDecorate {
    //二级缓存 装饰不改变原有代码实现额外增强
    @Override
    public <T> T getCache(String key) {
        // 先查询一级缓存 一级缓存中如果有数据则直接返回
        UserEntity jvmUser = super.getCache(key);
        if (jvmUser != null) {
            return (T) jvmUser;
        }
        // 查询二级缓存 二级缓存如果有数据则直接返回二级缓存中的数据
        String redisJson = RedisUtil.getString(key);
        if (StringUtils.isEmpty(redisJson)) {
            return null;
        }
        UserEntity redisUser = JSONObject.parseObject(redisJson, UserEntity.class);
        // 需要将数据存放在 jvm内存中 一级缓存中
        JvmMapCacheUtils.putEntity(key, redisUser);
        return (T) redisUser;
    }
}
