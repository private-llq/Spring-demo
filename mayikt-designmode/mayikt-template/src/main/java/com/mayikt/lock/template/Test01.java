package com.mayikt.lock.template;

import com.mayikt.lock.template.impl.RedisDistributedLockTemplate;
import com.mayikt.lock.template.impl.ZkDistributedLockTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 余胜军
 * @ClassName Test01
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Slf4j
public class Test01 {
    public static void main(String[] args) {
        DistributedLockTemplate redisDistributedLockTemplate
                = new ZkDistributedLockTemplate();
        redisDistributedLockTemplate.lock();
       log.info("<1111>");
        redisDistributedLockTemplate.unLock();
    }
}
