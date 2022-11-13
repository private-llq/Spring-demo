package org.example.jdk8.jdk8Interface;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.jdk8.jdk8Interface
 * @date 2022/11/13 10:43
 * @description: jdk8
 */
public interface Jdk8Interface {
    void add();

    /**
     * jdk8默认的方法
     */
    default void get(){
        System.out.println("jdk8的新增特性");
    }

    static void staticDel(){
        System.out.println("jdk8的新增特性Del");
    }
}
