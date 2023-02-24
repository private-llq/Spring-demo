package com.mayiakt.strategy.impl;

import com.mayiakt.strategy.PayStrategy;
import org.springframework.stereotype.Component;

/**
 * @author 余胜军
 * @ClassName WeChatPayStrategy
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Component
public class WeChatPayStrategy implements PayStrategy {
    @Override
    public String toPayHtml() {
        return "调用微信支付接口";
    }
}
