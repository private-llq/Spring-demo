package org.example.springdemo.service.impl;

import org.example.springdemo.service.OrderService;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.service.impl
 * @date 2022/12/3 17:49
 * @description: 公司
 */
public class OrderServiceImpl implements OrderService {

    @Override
    public String addOrder(String orderName) {
        System.out.println("addOrder方法之前处理");
        System.out.println("<orderName:{}>"+orderName);
        System.out.println("addOrder方法之后处理");
        return "ok";
    }

}
