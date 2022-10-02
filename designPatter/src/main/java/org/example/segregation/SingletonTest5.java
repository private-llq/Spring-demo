package org.example.segregation;

/**
 * @program: spring-demo
 * @description: 看似线程安全，但不一定安全。
 * 结论：不推荐使用。
 * @author: liulq
 * @create: 2022-10-02 15:14
 */
public class SingletonTest5 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
    }


    //懒汉式（线程安全，同步代码块）
    static class Singleton {
        private static Singleton instance;

        private Singleton() {

        }

        public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    instance = new Singleton();
                }
            }
            return instance;
        }
    }
}


