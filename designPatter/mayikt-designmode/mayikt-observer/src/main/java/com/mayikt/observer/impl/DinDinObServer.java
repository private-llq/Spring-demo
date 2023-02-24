package com.mayikt.observer.impl;

import com.mayikt.observer.ObServer;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 余胜军
 * @ClassName DinDinObServer
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Slf4j
public class DinDinObServer  implements ObServer {
    @Override
    public void update(String message) {
        log.info("<接受到数据，开始发送钉钉通知>");
    }
}
