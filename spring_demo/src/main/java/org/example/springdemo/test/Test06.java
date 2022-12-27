package org.example.springdemo.test;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuliangqi
 * @date 2022/12/27 14:57
 * ThreadLocal
 */
public class Test06 {
        // Atomic integer containing the next thread ID to be assigned
        private static final AtomicInteger nextId = new AtomicInteger(0);

        // Thread local variable containing each thread's ID
        private static final ThreadLocal<Integer> threadId =
                new ThreadLocal<Integer>() {
                    @Override protected Integer initialValue() {
                        System.out.println("进来了");
                        return nextId.getAndIncrement();
                    }
                };

        // Returns the current thread's unique ID, assigning it if necessary
        public static int get() {
            return threadId.get();
    }

    public static void main(String[] args) {
        Test06.get();
    }
}
