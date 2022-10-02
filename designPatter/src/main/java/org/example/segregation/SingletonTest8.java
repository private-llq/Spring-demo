package org.example.segregation;

/**
 * @program: spring-demo
 * @description: 枚举
 * 优缺点说明：
 * 这借助了JDK1.5中添加的枚举来实现单例模式，不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象；
 * 结论：推荐使用
 * @author: liulq
 * @create: 2022-10-02 15:17
 */
public class SingletonTest8 {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);
        instance.sayOK();

    }

    //使用枚举，可以实现单例
    enum Singleton {
        INSTANCE;//属性

        public void sayOK() {
            System.out.println("ok");
        }
    }
}

