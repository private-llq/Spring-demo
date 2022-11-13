package org.example.jdk8.jdk8Interface;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.jdk8.jdk8Interface
 * @date 2022/11/13 10:46
 * @description: JDK8
 */
public class Jdk8InterfaceImpl implements Jdk8Interface{
    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void get() {
        Jdk8Interface.super.get();
    }
}
