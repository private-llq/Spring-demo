package com.mayikt.decorate;

import com.mayikt.entity.UserEntity;
import com.mayikt.utils.JvmMapCacheUtils;
import org.springframework.stereotype.Component;

/**
 * @author 余胜军
 * @ClassName JvmComponentCache
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Component
public class JvmComponentCache implements ComponentCache {
    @Override
    public <T> T getCache(String key) {
        // 1.一级缓存 从jvm中查询到数据
        UserEntity user = JvmMapCacheUtils.getEntity(key, UserEntity.class);
        return (T) user;
    }
}
