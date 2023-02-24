package com.mayikt.chain.factory;

import com.mayikt.chain.GatewayHandler;
import com.mayikt.chain.impl.BlacklistHandler;
import com.mayikt.chain.impl.ConversationHandler;
import com.mayikt.chain.impl.CurrentLimitHandler;
import com.mayikt.chain.utils.SpringUtils;

/**
 * @author 余胜军
 * @ClassName FactoryHandler
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class FactoryHandler {

    public static GatewayHandler getGatewayHandler() {
//        // 1.设置黑名单BlacklistHandler
//        BlacklistHandler blacklistHandler = new BlacklistHandler();
//        blacklistHandler.setNextGatewayHandler(new ConversationHandler());
//        // 2.设置api接口限流的Handler 下一个Handler 黑名单Handler
//        CurrentLimitHandler currentLimitHandler = new CurrentLimitHandler();
//        currentLimitHandler.setNextGatewayHandler(blacklistHandler);
        // 1. 设置黑名单BlacklistHandler
        ConversationHandler conversationHandler = SpringUtils.getBean("conversationHandler", ConversationHandler.class);
        BlacklistHandler blacklistHandler = SpringUtils.getBean("blacklistHandler", BlacklistHandler.class);
        blacklistHandler.setNextGatewayHandler(conversationHandler);
        // 2.设置api接口限流的Handler 下一个Handler 黑名单Handler
        CurrentLimitHandler currentLimitHandler = SpringUtils.getBean("currentLimitHandler", CurrentLimitHandler.class);
        currentLimitHandler.setNextGatewayHandler(blacklistHandler);
        return currentLimitHandler;
    }

    public static void main(String[] args) {
//        GatewayHandler gatewayHandler = FactoryHandler.getGatewayHandler();
//        gatewayHandler.doService();
    }
}
