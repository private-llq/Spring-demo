package com.mayikt.observer.impl;

import com.mayikt.observer.MsgObServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 余胜军
 * @ClassName EmailObServer
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Component
@Slf4j
public class EmailObServer implements MsgObServer {
    @Override
    public void update(String message) {
        log.info("发送邮件:{}", message);
    }
}
