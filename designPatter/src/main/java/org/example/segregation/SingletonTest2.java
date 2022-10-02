package org.example.segregation;

/**
 * @program: spring-demo
 * @description: 饿汉式（静态代码块）
 * 优缺点说明：
 * 这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块中，也是在类装载的时候，就执行静态代码快中的代码，初始化类的实例。优缺点和上面是一样的。
 * 结论：这种单例模式可用，但是可能造成内存浪费。
 * @author: liulq
 * @create: 2022-10-02 15:11
 */
public class SingletonTest2 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
    }


    //饿汉式（静态代码块）
    static class Singleton {
        //1、构造器私有化，外部不能new
        private Singleton() {

        }

        //2、静态代码块
        private static Singleton instance;

        static {
            instance = new Singleton();
        }

        //3、提供一个公有的静态方法，返回实例对象
        public static Singleton getInstance() {
            return instance;
        }
    }
}

