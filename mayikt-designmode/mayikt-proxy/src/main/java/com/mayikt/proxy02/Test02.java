package com.mayikt.proxy02;

/**
 * @author 余胜军
 * @ClassName Test02
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test02 {
    public static void main(String[] args) {
        OrderServiceProxy orderServiceProxy = new OrderServiceProxy();
        orderServiceProxy.addOrder("mayikt");
    }
}
