package org.example.segregation;

import java.lang.reflect.Constructor;

/**
 * @program: spring-demo
 * @description: 单例模式- 饿汉式，线程安全
 * 优缺点说明：
 * 优点：这种写法比较简单，就是在类装载的时候就完成实例化，避免了线程同步问题；
 * 缺点：在类装载的时候就完成实例化，没有达到懒加载的效果，如果从始至终从未使用过这个实例，则会造成内存的浪费；
 * 这种方式基于classloder机制避免了多线程的同步问题，不过，instance在类装载时就实例化，在单例模式中大多数都是调用getInstance方法，但是导致类装载的原因有很多种，因此不能确定有其他的方式（或者其他静态方法）导致类加载，这时候初始化instance就没有达到懒加载的效果。
 * 结论：这种单例模式可用，可能造成内存浪费。
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
