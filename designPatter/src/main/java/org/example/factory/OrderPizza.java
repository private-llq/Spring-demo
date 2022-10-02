package org.example.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: spring-demo
 * @description: 订单
 * @author: llq
 * @create: 2022-10-02 15:44
 */
public class OrderPizza {
    /**
     * 构造方法
     */
    public OrderPizza() {
        Pizza pizza;
        String orderType;//订购披萨的类型
        do {
            orderType = getType();
            if ("greek".equals(orderType)) {
                pizza = new GreekPizza();
                pizza.setName("GreekPizza");
            } else if ("cheess".equals(orderType)) {
                pizza = new CheessPizza();
                pizza.setName("CheessPizza");
            } else {
                break;
            }
            //输出pizza制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);
    }

    /**
     * 写一个方法，可以获取客户希望订购的披萨种类
     */
    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:请写出你的 披萨 类型：");
            String str;
            str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}

