package com.mayikt.chain.service;

import com.mayikt.chain.GatewayHandler;
import com.mayikt.chain.manage.GatewayHandlerManage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 余胜军
 * @ClassName TestChainService
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@RestController
@Slf4j
public class TestChainService {
    @Autowired
    private GatewayHandlerManage gatewayHandlerManage;

    /**
     * 测试责任链
     *
     * @return
     */
    @RequestMapping("/testChain")
    public String testChain() {
        try {
            GatewayHandler gatewayHandler = gatewayHandlerManage.getFirstGatewayHandler();
            gatewayHandler.doService();
            //业务代码  如果doService方法中 某一个环节 没有过了的情况下就不会执行 24行业务代码
            /**
             * 封装的方式
             * 1.方法加上返回值 拦截器（多拦截器） true
             * 2.抛出异常
             */
            return "业务代码";
        } catch (Exception e) {
            log.error("<权限不足，中间部分环节没有通过>");
            return "fail";
        }

    }
}
