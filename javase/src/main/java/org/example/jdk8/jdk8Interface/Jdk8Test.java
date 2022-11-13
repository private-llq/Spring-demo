package org.example.jdk8.jdk8Interface;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.jdk8.jdk8Interface
 * @date 2022/11/13 10:47
 * @description: 测试
 */
public class Jdk8Test {
    public static void main(String[] args) {
        Jdk8InterfaceImpl jdk8Interface =new Jdk8InterfaceImpl();
        jdk8Interface.add();
        jdk8Interface.get();
        Jdk8Interface.staticDel();
    }
}
