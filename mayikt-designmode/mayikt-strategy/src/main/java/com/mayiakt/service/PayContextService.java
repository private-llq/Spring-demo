package com.mayiakt.service;

import com.mayiakt.entity.PaymentChannelEntity;
import com.mayiakt.mapper.PaymentChannelMapper;
import com.mayiakt.strategy.PayStrategy;
import com.mayiakt.strategy.factory.StrategyFactory;
import com.mayiakt.strategy.impl.AliPayStrategy;
import com.mayiakt.strategy.impl.UnionPayStrategy;
import com.mayiakt.strategy.impl.WeChatPayStrategy;
import com.mayiakt.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 余胜军
 * @ClassName PayContextService
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@RestController
public class PayContextService {
    private StrategyFactory strategyFactory = new StrategyFactory();
    @Autowired
    private PaymentChannelMapper paymentChannelMapper;

    /**
     * 用户选择支付的方式
     *
     * @return
     */
    @GetMapping("/toPayHtml")
    public String toPayHtml(String userCode) {
//        if ("WeChatPayStrategy".equals(userCode)) {
//            return new WeChatPayStrategy().toPayHtml();
//        }
//        if ("UnionPayStrategy".equals(userCode)) {
//            return new UnionPayStrategy().toPayHtml();
//        }
//        if ("AliPayStrategy".equals(userCode)) {
//            return new AliPayStrategy().toPayHtml();
//        }
        if (StringUtils.isEmpty(userCode)) {
            return "userCode is null";
        }
        //使用策略查找具体策略实现
        // 底层通过ioc容器 用户根据beanid 从ioc容器中查找到具体的bean对象
//        PayStrategy payStrategy = strategyFactory.getPayStrategy(userCode);
        // 用户根据beanid 从ioc容器中查找到具体的bean对象
//        PayStrategy payStrategy = SpringUtils.getBean(userCode, PayStrategy.class);
        PaymentChannelEntity paymentChannel = paymentChannelMapper.getPaymentChannel(userCode);
        if (paymentChannel == null) {
            return "userCode error or 该渠道已经关闭 暂时没有合作";

        }
        // 用户根据beanid 从ioc容器中查找到具体的bean对象
        String strategyBeanId = paymentChannel.getStrategyBeanId();
        PayStrategy payStrategy = SpringUtils.getBean(strategyBeanId, PayStrategy.class);
        if (payStrategy == null) {
            return "PayStrategy  not fount";
        }
        return payStrategy.toPayHtml();
    }
}
