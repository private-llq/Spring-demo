package org.example.springdemo.service.proxy;

import org.example.springdemo.service.OrderService;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.service.proxy
 * @date 2022/12/3 18:16
 * @description: 公司
 */
public class OrderServiceProxy implements OrderService {
    private OrderService orderService;

    public OrderServiceProxy(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String addOrder(String orderName) {
        // 目标方法前后处理操作
        System.out.println("<目标方法之前执行...>");
        String result = orderService.addOrder(orderName);
        System.out.println("<目标方法之后执行...>");
        return result;
    }
}
