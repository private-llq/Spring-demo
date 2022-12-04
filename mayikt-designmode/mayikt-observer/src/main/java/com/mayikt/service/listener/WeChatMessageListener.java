package com.mayikt.service.listener;

import com.mayikt.service.entity.MsgEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author 余胜军
 * @ClassName WeChat
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Slf4j
@Component
public class WeChatMessageListener implements ApplicationListener<MsgEntity> {

    @Override
    @Async
    public void onApplicationEvent(MsgEntity event) {
        // 发送微信
        log.info("<发送微信:{}>", event.toString());
    }
}
