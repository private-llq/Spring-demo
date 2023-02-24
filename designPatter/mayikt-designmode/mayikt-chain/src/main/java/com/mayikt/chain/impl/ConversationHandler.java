package com.mayikt.chain.impl;

import com.mayikt.chain.GatewayHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 余胜军
 * @ClassName CurrentLimitHandler
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Slf4j
@Component
public class ConversationHandler extends GatewayHandler {
    @Override
    public void doService() throws Exception {
        log.info("第三关：验证会话信息处理流程");
        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();
        String name = request.getParameter("name");
        if (StringUtils.isEmpty(name)) {
            throw new Exception("name is null");
        }
        if ("mayikt".equals(name)) {
            throw new Exception("权限不足");
        }

    }

    @Override
    public void setNextGatewayHandler(GatewayHandler nextGatewayHandler) {
        this.nextGatewayHandler = nextGatewayHandler;
    }
}
