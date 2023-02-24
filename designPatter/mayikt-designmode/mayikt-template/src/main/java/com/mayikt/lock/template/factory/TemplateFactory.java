package com.mayikt.lock.template.factory;

import com.mayikt.lock.template.DistributedLockTemplate;
import com.mayikt.lock.template.utils.SpringUtils;

/**
 * @author 余胜军
 * @ClassName TemplateFactory
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class TemplateFactory {
    public static DistributedLockTemplate getDistributedLockTemplate(String distributedLockTemplateId) {
        return SpringUtils.getBean(distributedLockTemplateId, DistributedLockTemplate.class);
    }
}
