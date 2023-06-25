package org.example.jdk8;

public @interface Anno1{
    //定义一个基本类型的属性
    int a() default 23;

    //定义一个String类型的属性
    public String name();

    //定义一个Class类型的属性
    public Class clazz() default Anno2.class;

    //定义一个注解类型的属性
    public Anno2 anno() default @Anno2();

    //以上类型的一维数组
    public int[] arr() default {1,2,3,4,5};
}