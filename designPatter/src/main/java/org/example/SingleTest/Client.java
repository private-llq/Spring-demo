package org.example.SingleTest;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.SingleTest
 * @date 2022/11/12 20:40
 * @description: 测试单例
 */
public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1); // true
    }
}
