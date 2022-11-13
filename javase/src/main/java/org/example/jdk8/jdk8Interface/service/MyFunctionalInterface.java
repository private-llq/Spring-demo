package org.example.jdk8.jdk8Interface.service;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.jdk8.jdk8Interface.service
 * @date 2022/11/13 14:52
 * @description: jdk8
 */
@FunctionalInterface
public interface MyFunctionalInterface {
    void  get();


    default void defaultDel(){
        System.out.println("默认方法");
    }

    @Override
    int hashCode();

    @Override
    String toString();
}
