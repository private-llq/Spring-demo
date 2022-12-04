package com.mayikt.chain.manage;

import com.mayikt.chain.GatewayHandler;
import com.mayikt.chain.entity.GatewayHandlerEntity;
import com.mayikt.chain.mapper.GatewayHandlerMapper;
import com.mayikt.chain.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author 余胜军
 * @ClassName GatewayHandlerManage
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Component
@Slf4j
public class GatewayHandlerManage {

    @Autowired
    private GatewayHandlerMapper gatewayHandlerMapper;
    private GatewayHandler firstGatewayHandler;

    public GatewayHandler getFirstGatewayHandler() {
        if (firstGatewayHandler != null) {
            return firstGatewayHandler;
        }
        // 1.先查询第一个 GatewayHandler ghEntity
        GatewayHandlerEntity firstghEntity = gatewayHandlerMapper.getFirstGatewayHandler();
        if (firstghEntity == null) {
            // 在db中没有配置 第一个GatewayHandler
            log.error("没有配置我们第一个GatewayHandler");
            return null;
        }
        String firstHandlerId = firstghEntity.getHandlerId();
        if (StringUtils.isEmpty(firstHandlerId)) {
            log.error("没有配置 firstHandlerBeanId");
            return null;
        }
        // IOC容器中得到第一个firstHandler
        GatewayHandler firstHandler = SpringUtils.getBean(firstHandlerId, GatewayHandler.class);
        // 2.继续 判断如果有下一个GatewayHandler 直接调用 GatewayHandler.setNextGatewayHandler();
        String nextHandlerId = firstghEntity.getNextHandlerId();
        GatewayHandler tempHandler = firstHandler;
        while (!StringUtils.isEmpty(nextHandlerId)) {
            GatewayHandler nextGatewayHandler = SpringUtils.getBean(nextHandlerId, GatewayHandler.class);
            tempHandler.setNextGatewayHandler(nextGatewayHandler);
            //根据nextHandlerId查询数据库db信息得到下一个GatewayHandler基本信息
            GatewayHandlerEntity nextghEntity = gatewayHandlerMapper.getByHandler(nextHandlerId);
            nextHandlerId = nextghEntity.getNextHandlerId();
            // 记录下来 当前循环到那个GatewayHandler
            tempHandler = nextGatewayHandler;
        }
        //  代码bug 每次改 第一个的下一个GatewayHandler
        this.firstGatewayHandler = firstHandler;
        return firstHandler;
    }
}
