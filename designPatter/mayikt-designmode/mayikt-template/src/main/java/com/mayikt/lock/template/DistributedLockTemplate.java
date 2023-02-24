package com.mayikt.lock.template;

import com.mayikt.lock.template.impl.RedisDistributedLockTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 余胜军
 * @ClassName DistributedLockTemplate
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Slf4j
public abstract class DistributedLockTemplate {
    /**
     * 分布式锁模板
     */
    /**
     * 获取锁锁方法
     */
    public void lock() {
        // 开始时间
        Long startTime = System.currentTimeMillis();
        tryLock(); // 将该方法变成抽象方法 让我们子类实现
        // 结束时间
        Long endTime = System.currentTimeMillis();
        log.info("获取锁的时间:{}", (endTime - startTime));
    }

    /**
     * 子类重写的
     */
    protected abstract void tryLock();

    /**
     * 释放锁方法
     */
    public void unLock() {
        // 开始时间
        Long startTime = System.currentTimeMillis();
        tryUnLock(); // 将该方法变成抽象方法 让我们子类实现
        // 结束时间
        Long endTime = System.currentTimeMillis();
        log.info("释放锁的时间:{}", (endTime - startTime));
    }

    protected abstract void tryUnLock();

    public static void main(String[] args) {
        /**
         * 抽象类new 抽象类的子类
         */
        DistributedLockTemplate distributedLockTemplate = new RedisDistributedLockTemplate();
        distributedLockTemplate.lock();
    }
}
