package com.mayikt.observer.impl;

import com.mayikt.observer.MsgObServer;
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
public class TextMessageObServer implements MsgObServer {
    @Override
    public void update(String messag) {
        log.info("<接受到数据，开始发送短信>");
    }
    /**
     * 主题分类 -------发送短信 发送邮件发送钉钉---- 登录提醒（登录提醒的参数都是一样）
     * 发送积分、赠送优惠券 调用别人
     */
}
