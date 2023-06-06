package org.example.test;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.test
 * @date 2022/10/17 20:20
 * @Copyright 三元表达式
 */
public class Test05 {
    /**
     * 语法： 数据类型 变量名称 =条件判断 ？表达式A ：表达式B
     */
    public static void main(String[] args) {
        //首先判断条件是否成立：
        //如果成立为true，那么将表达式A的值赋值给左侧的变量；如果不成立为false，那么将表达式B的值赋值给左侧的变量；二者选其一。
        int a = 10;
        int b = 20;
        int max = a > b ? a : b;
        System.out.println(max);
        System.out.println("----------------");
        System.out.println("输出");

    }
}
