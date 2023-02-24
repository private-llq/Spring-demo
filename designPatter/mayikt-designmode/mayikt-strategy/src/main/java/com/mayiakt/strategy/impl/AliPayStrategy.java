package com.mayiakt.strategy.impl;

import com.mayiakt.strategy.PayStrategy;
import org.springframework.stereotype.Component;

/**
 * @author 余胜军
 * @ClassName AliPayStrategy
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Component
public class AliPayStrategy implements PayStrategy {
    @Override
    public String toPayHtml() {
        return "调用支付宝接口";
    }
}
