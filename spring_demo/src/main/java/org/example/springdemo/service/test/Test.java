package org.example.springdemo.service.test;

import org.example.springdemo.service.impl.OrderServiceImpl;
import org.example.springdemo.service.proxy.OrderServiceProxy;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.service.test
 * @date 2022/12/3 18:20
 * @description: 公司
 */
public class Test {
    public static void main(String[] args) {
        OrderServiceProxy orderServiceProxy = new OrderServiceProxy(new OrderServiceImpl());
        String liuliangqi = orderServiceProxy.addOrder("liuliangqi");
        System.out.println(liuliangqi);
    }
}
