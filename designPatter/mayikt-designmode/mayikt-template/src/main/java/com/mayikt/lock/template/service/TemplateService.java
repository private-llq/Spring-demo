package com.mayikt.lock.template.service;

import com.mayikt.lock.template.DistributedLockTemplate;
import com.mayikt.lock.template.factory.TemplateFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 余胜军
 * @ClassName TemplateService
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@RestController
@Slf4j
public class TemplateService {

    @RequestMapping("/templateLock")
    public String templateLock(String distributedLockTemplateId) {
        DistributedLockTemplate distributedLockTemplate = TemplateFactory.getDistributedLockTemplate(distributedLockTemplateId);
        // 从ioc容器中获取到具体的分布式锁实现方式
        distributedLockTemplate.lock();
        log.info("代码执行...");
        distributedLockTemplate.unLock();
        return "ok";
    }
}
