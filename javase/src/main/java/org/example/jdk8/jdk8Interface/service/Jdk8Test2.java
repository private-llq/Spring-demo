package org.example.jdk8.jdk8Interface.service;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.jdk8.jdk8Interface.service
 * @date 2022/11/13 15:11
 * @description: Jdk8 的lambda表达式带无参构造
 */
public class Jdk8Test2 {
    public static void main(String[] args) {
        //匿名内部类
        new AcanthopaxInterface() {
            @Override
            public void get() {
                System.out.println("get");
            }
        }.get();
        //Lambda表达式
        AcanthopaxInterface acanthopaxInterface= ()->{
            System.out.println("使用lamdba表达式");
        };
        acanthopaxInterface.get();
        ((AcanthopaxInterface) () -> System.out.println("get")).get();


    }
}
