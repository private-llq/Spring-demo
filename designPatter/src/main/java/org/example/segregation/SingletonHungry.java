package org.example.segregation;

import java.lang.reflect.Constructor;

/**
 * @program: spring-demo
 * @description: 单例模式- 饿汉式，线程安全
 *
 * @author: liulq
 * @create: 2022-10-02 10:32
 */
public class SingletonHungry {
    private SingletonHungry() {
    }

    private final static SingletonHungry instance = new SingletonHungry();

    public static SingletonHungry getSingleton() {
        System.out.println("进入单例模式");
        return instance;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getSingleton());
         //使⽤反射破坏单例
         //获取空参构造⽅法
        Constructor<SingletonHungry> declaredConstructor = SingletonHungry.class.getDeclaredConstructor(null);;
        //设置强制访问
        declaredConstructor.setAccessible(true);
        //创建实例
        SingletonHungry singleton = declaredConstructor.newInstance();

        System.out.println("反射创建的实例：" + singleton);
        System.out.println("正常创建的实例" + SingletonHungry.getSingleton());
        System.out.println("正常创建的实例" + SingletonHungry.getSingleton());
    }


}
