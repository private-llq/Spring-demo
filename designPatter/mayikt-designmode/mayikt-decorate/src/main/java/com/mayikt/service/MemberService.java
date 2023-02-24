package com.mayikt.service;

import com.mayikt.decorate.MySQLDecorate;
import com.mayikt.entity.UserEntity;
import com.mayikt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 余胜军
 * @ClassName MemberService
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@RestController
public class MemberService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MySQLDecorate mySQLDecorate;

//
//    @RequestMapping("/getMember")
//    public UserEntity getMember(Integer id) {
//        if (StringUtils.isEmpty(id)) {
//            return null;
//        }
//        // 1.先查询一级缓存，一级缓存有的情况下 直接返回 如果一级缓存没有的情况下则 查询二级缓存
//        String cacheKey = "com.mayikt.service.MemberService.getMember,Integer:" + id;
//        UserEntity jvmUserEntity = JvmMapCacheUtils.getEntity(cacheKey, UserEntity.class);
//        if (jvmUserEntity != null) {
//            return jvmUserEntity;
//        }
//        // 2.查询二级缓存 （走redis）
//        String redisJson = RedisUtil.getString(cacheKey);
//        if (!StringUtils.isEmpty(redisJson)) {
//            UserEntity redisUser = JSONObject.parseObject(redisJson, UserEntity.class);
//            // 需要将数据存放在 jvm内存中
//            JvmMapCacheUtils.putEntity(cacheKey, redisUser);
//            return redisUser;
//        }
//        // 3.查询三级缓存 数据库
//        UserEntity dbUser = userMapper.findByUser(id);
//        if (dbUser == null) {
//            return null;
//        }
//        // 三级缓存中数据存放在二级和一级缓存
//        RedisUtil.setString(cacheKey, JSONObject.toJSONString(dbUser));
//        JvmMapCacheUtils.putEntity(cacheKey, dbUser);
//        // 扩展新增级别缓存 改动了
//        return dbUser;
//    }

    @RequestMapping("/getMember")
    public UserEntity getMember(Integer id) {
        return mySQLDecorate.getCache("com.mayikt.service.MemberService.getMember()Integer:" + id
        );
    }
}
