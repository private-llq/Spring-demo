package com.mayikt.lock.template.impl;

import com.mayikt.lock.template.DistributedLockTemplate;
import org.springframework.stereotype.Component;

/**
 * @author 余胜军
 * @ClassName RedisDistributedLockTemplate
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Component
public class RedisDistributedLockTemplate extends DistributedLockTemplate {
    @Override
    protected void tryLock() {
        try {
            Thread.sleep(10);
        } catch (Exception e) {

        }
        System.out.println("redis获取分布式锁");
    }

    @Override
    protected void tryUnLock() {
        try {
            Thread.sleep(5);
        } catch (Exception e) {

        }
        System.out.println("redis释放分布式锁");
    }
}
