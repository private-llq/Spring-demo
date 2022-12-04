package com.mayikt.proxy03;

import com.mayikt.service.OrderService;
import com.mayikt.service.impl.OrderServiceImpl;

/**
 * @author 余胜军
 * @ClassName Test01
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test01 {
    public static void main(String[] args) {
        // 将jdk动态生成好的 class 存放本地
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // com.sun.proxy.$Proxy0 cannot be cast to com.mayikt.service.impl.OrderServiceImpl
        OrderService orderService = new MayiktInvocationHandler(new OrderServiceImpl()).getProxy();// 代理类
        orderService.addOrder("mayikt");
        // 分析jdk底层如何生成该代理类？ 长什么样子？
        // jdk生成好的代理类 实现了目标对象的接口


    }
}
