package org.example.springdemo.service;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.service
 * @date 2022/12/3 17:46
 * @description: 公司
 */
public interface OrderService {
    /**
     * 添加订单数据
     * @param orderName
     * @return String
     */
    String addOrder(String orderName);
}
