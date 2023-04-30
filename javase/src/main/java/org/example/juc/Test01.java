package org.example.juc;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.juc
 * @date 2023/4/30 11:15
 * @description: 公司
 */
public class Test01 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("test"));
        t.start();
        System.out.println("main1");
        try {
            t.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main2");
    }
}
