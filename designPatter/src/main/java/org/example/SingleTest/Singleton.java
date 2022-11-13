package org.example.SingleTest;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.SingleTest
 * @date 2022/11/12 20:37
 * @description: 1.饿汉式-方式1（静态变量方式）
 * 	该方式在成员位置声明Singleton类型的静态变量，并创建Singleton类的对象instance。instance对象是随着类的加载而创建的。如果该对象足够大的话，而一直没有使用就会造成内存的浪费。
 */
public class Singleton {
    // 1.私有构造器
    private Singleton(){}
    // 2.在本类中创建本类的对象
    private static Singleton instance = new Singleton();
    // 3.提供公共的访问方法
    public static Singleton getInstance(){
        return instance;
    }
}
