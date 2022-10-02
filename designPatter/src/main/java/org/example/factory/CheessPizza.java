package org.example.factory;

/**
 * @program: spring-demo
 * @description:
 * @author: liulq
 * @create: 2022-10-02 15:43
 */
public class CheessPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给CheessPizza准备原材料");
    }
}

