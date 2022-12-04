package com.mayikt.service.impl;

import com.mayikt.service.OrderService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 余胜军
 * @ClassName OrderServiceImpl
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Slf4j
public class OrderServiceImpl implements OrderService {
//    @Override
    public String addOrder(String orderName) {
        log.info("<orderName:{}>", orderName);
        // addorder相关的事情
        return "ok";
    }
}
