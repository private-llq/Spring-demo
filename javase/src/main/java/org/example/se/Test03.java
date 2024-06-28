package org.example.se;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.se
 * @date 2024/6/26 11:12
 * @description: 公司
 */
public class Test03 {
    public static void main(String[] args) {
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();

        threadLocal.set("123");

        Counter counter = new Counter();
        counter.add(1);
        counter.add(1);
        counter.add(1);
        System.out.println(counter.count);

    }


    public static class Counter {
        private final Lock lock = new ReentrantLock();
        private int count;
        public void add(int n) {
            lock.lock();
            try {
                count += n;
            } finally {
                lock.unlock();
            }
        }
    }





}
