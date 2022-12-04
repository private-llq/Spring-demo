package com.mayikt.utils;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.entity.UserEntity;

import java.util.HashMap;

public class JvmMapCacheUtils<V> {



    private static HashMap<String, String> cacheMap = new HashMap<String, String>();

    public static void putEntity(String key, Object object) {
        cacheMap.put(key, JSONObject.toJSONString(object));
    }

    public static <T> T getEntity(String key, Class<T> t) {
        String json = cacheMap.get(key);
        JSONObject jsonObject = JSONObject.parseObject(json);
        return JSONObject.parseObject(json, t);
    }

    public static void main(String[] args) {
        UserEntity userEntity = new UserEntity(1, "mayikt", 22);
        JvmMapCacheUtils.putEntity("user1", userEntity);
        UserEntity user = JvmMapCacheUtils.getEntity("user1", UserEntity.class);
        System.out.println(user);
    }
}