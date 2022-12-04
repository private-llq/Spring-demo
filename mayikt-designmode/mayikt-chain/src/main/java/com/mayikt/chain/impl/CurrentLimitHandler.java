package com.mayikt.chain.impl;

import com.mayikt.chain.GatewayHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 余胜军
 * @ClassName CurrentLimitHandler
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Slf4j
@Component
public class CurrentLimitHandler extends GatewayHandler {
    @Override
    public void doService() throws Exception {
        log.info("<第一关api接口限流>");
        // 第一关 放行  过了
        nextGatewayHandler.doService();// 过滤器中放行方法
    }

    @Override
    public void setNextGatewayHandler(GatewayHandler nextGatewayHandler) {
        this.nextGatewayHandler = nextGatewayHandler;
    }
}
