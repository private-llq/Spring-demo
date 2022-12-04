package com.mayikt.chain.impl;

import com.mayikt.chain.GatewayHandler;
import lombok.extern.slf4j.Slf4j;
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
public class BlacklistHandler extends GatewayHandler {
    @Override
    public void doService() throws Exception {
        log.info("第二关：黑名单处理");
        String remoteIp = getRemoteIp();
        if ("127.0.0.1".equals(remoteIp)) {
            // 被限流无法执行下一个流程
            String errorMsg = "该ip地址:" + remoteIp + ",已经被拉黑 无法访问";
            log.error(errorMsg);
            throw new Exception(errorMsg);
        }
        nextGatewayHandler.doService();
    }

    public static String getRemoteIp() {
        HttpServletRequest request = null;
        try {
            request =
                    ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        } catch (Exception e) {
            System.out.println("Can not get current IP.");
        }
        return request.getRemoteAddr();
    }

    @Override
    public void setNextGatewayHandler(GatewayHandler nextGatewayHandler) {
        this.nextGatewayHandler = nextGatewayHandler;
    }
}
