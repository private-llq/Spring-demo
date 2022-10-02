package org.example.segregation;

/**
 * @program: spring-demo
 * @description: 优缺点说明：
 * 静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，会装载SingletonInstance类，从而完成Singleton的实例化；
 * 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的；
 * 优点：避免了线程不安全，利用静态内部类特点实现延迟加载，效率高；
 * 结论：推荐使用
 * @author: liulq
 * @create: 2022-10-02 15:16
 */
public class SingletonTest7 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
    }


    //静态内部类
    static class Singleton {

        private Singleton() {
        }

        //写一个静态内部类，该类中有一个静态属性Singleton
        private static class singleInstance {
            private static final Singleton INSTANCE = new Singleton();
        }

        //提供一个静态的公有方法，直接返回对象
        public static synchronized Singleton getInstance() {
            return singleInstance.INSTANCE;
        }
    }
}


