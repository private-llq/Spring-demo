package com.mayikt.observer.jdk;

import com.mayikt.observer.ObServer;
import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

/**
 * @author 余胜军
 * @ClassName WeChatObServer
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Slf4j
public class JdkWeChatObServer implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        // Observable o 获取主题
        // arg 观察者得到对象
        log.info("<接受到数据，发送微信模板> msg:" + arg);
    }
}
