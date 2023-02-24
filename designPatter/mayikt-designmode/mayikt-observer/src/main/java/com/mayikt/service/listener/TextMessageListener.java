package com.mayikt.service.listener;

import com.mayikt.service.entity.MsgEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author 余胜军
 * @ClassName TextMessageListener
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Component
@Slf4j
public class TextMessageListener implements ApplicationListener<MsgEntity> {


    @Override
    @Async
    public void onApplicationEvent(MsgEntity event) {
        int j = 1 / 0;
        log.info("<发送短信:{}>", event.toString());
    }
    /**
     * 项目中如果整合到了多线程----结合线程池 ----线程池配置线程池名称
     */
}
