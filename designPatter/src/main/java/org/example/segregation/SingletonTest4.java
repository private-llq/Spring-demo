package org.example.segregation;

/**
 * @program: spring-demo
 * @description:
 * @author: liulq
 * @create: 2022-10-02 15:12
 */
public class SingletonTest4 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
    }

    //懒汉式（线程安全，同步方法）
    static class Singleton {
        private static Singleton instance;

        private Singleton() {

        }

        //提供一个静态的公有方法，加入同步处理的代码，解决线程安全问题
        public static synchronized Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }
}
