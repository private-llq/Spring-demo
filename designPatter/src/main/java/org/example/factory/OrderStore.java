package org.example.factory;

/**
 * @program: spring-demo
 * @description: 相当于客户端
 * @author: liulq
 * @create: 2022-10-02 15:45
 */
public class OrderStore {
    public static void main(String[] args) {
        OrderPizza orderPizza = new OrderPizza();
        System.out.println(orderPizza);
    }
}

