package com.mayikt.observer.impl;

import com.mayikt.observer.MsgObServer;
import com.mayikt.observer.ObServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 余胜军
 * @ClassName WeChatObServer
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Slf4j
@Component
public class WeChatObServer implements MsgObServer {
    @Override
    public void update(String messag) {
        log.info("<接受到数据，开始发送微信模板>");
    }
}
