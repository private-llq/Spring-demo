package org.example.jdk8.jdk8Interface.service;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.jdk8.jdk8Interface.service
 * @date 2022/11/13 10:58
 * @description: 测试
 */
public class Jdk8Test1 {
    public static void main(String[] args) {
        //原始写法
        OrderService orderService = new OrderService() {
            @Override
            public void get() {
                System.out.println("get");
            }
        };
        orderService.get();
       //lambda的写法
        OrderService Service = () -> System.out.println("get");


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+",run");
            }
        }).start();
        //lambda的写法
        new Thread(() -> System.out.println(Thread.currentThread().getName()+",run")).start();
    }
}
