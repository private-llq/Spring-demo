package com.mayikt.proxy;

import com.mayikt.service.OrderService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 余胜军
 * @ClassName OrderServiceProxy
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Slf4j
public class OrderServiceProxy implements OrderService {
    // 代理类 到底是需要调用哪一个 被代理类？
    private OrderService orderService;

    public OrderServiceProxy(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String addOrder(String orderName) {
        log.info("<在addorder方法之前处理  orderName:{}>", orderName);
        String result = orderService.addOrder(orderName);// 调用到被代理类1
        log.info("<在addorder方法之后处理  orderName:{}>", orderName);
        return result;
    }
}
