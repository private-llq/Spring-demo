package com.mayikt.observer.jdk;

//import com.mayikt.observer.ObServer;

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
public class JdkTextMessageObServer implements Observer {
//    @Override
//    public void update(String messag) {
//        log.info("<接受到数据，开始发送短信>");
//    }

    @Override
    public void update(Observable o, Object arg) {
        // Observable o 获取主题
        // arg 观察者得到对象
        log.info("<接受到数据，开始发送短信> msg:" + arg);
    }
    /**
     * 主题分类 -------发送短信 发送邮件发送钉钉---- 登录提醒（登录提醒的参数都是一样）
     * 发送积分、赠送优惠券 调用别人
     */
}
