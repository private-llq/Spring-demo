package com.mayiakt.strategy;

/**
 * @author 余胜军
 * @ClassName PayStrategy
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public interface PayStrategy {
    /**
     * 调用支付接口 基本支付思想都是相同
     * form表单提交 支付接口
     * 抽象方法---具体的实现 实现类完成
     */
    String toPayHtml();
}
