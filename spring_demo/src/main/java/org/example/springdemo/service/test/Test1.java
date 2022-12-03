package org.example.springdemo.service.test;

import org.example.springdemo.service.OrderService;
import org.example.springdemo.service.impl.OrderServiceImpl;
import org.example.springdemo.service.proxy.MkInvcationHandler;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.service.test
 * @date 2022/12/3 20:19
 * @description: 公司
 */
public class Test1 {
    public static void main(String[] args) {
        //获取代理的生成的class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        MkInvcationHandler jdkInvocationHandler = new MkInvcationHandler(new OrderServiceImpl());
        OrderService orderService = jdkInvocationHandler.getProxy();
        orderService.addOrder("liuliangqi");
        //jdk生成
    }
}
