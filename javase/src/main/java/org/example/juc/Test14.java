package org.example.juc;

import java.util.stream.Stream;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.juc
 * @date 2023/11/11 15:54
 * @description: 公司
 */
public class Test14 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2");
            }
        });
        t1.start();
        t2.start();
        System.out.println("main");
    }
}
