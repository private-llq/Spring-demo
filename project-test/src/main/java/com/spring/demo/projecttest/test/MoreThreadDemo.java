package com.spring.demo.projecttest.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * 多线程情况下的比较
 *
 * @author icanci
 * @since 1.0 Created in 2022/06/06 21:28
 */
public class MoreThreadDemo {
    // 1千万
    protected static final int count = 1000 * 10000;

    protected static int       num   = 0;

    public static void main(String[] args) throws Exception {
        // 线程数量 - 执行多少次( 1000 * 10000 )
        tests(1, count);
        tests(2, count);
        tests(10, count);
        tests(20, count);
        tests(40, count);
        tests(60, count);
        tests(80, count);
        tests(100, count);
    }

    /**
     * test
     *
     * @param threadCount 线程数量
     * @param times 每个线程自增多少次
     */
    private static void tests(final int threadCount, final int times) {

        // synchronized
        staticLog(() -> {
            testSynchronized(threadCount, times);
        }, "synchronized");

        // AtomicInteger
        staticLog(() -> {
            testAtomicInteger(threadCount, times);
        }, "AtomicInteger");

        // AtomicLong
        staticLog(() -> {
            testAtomicLong(threadCount, times);
        }, "AtomicLong");

        // LongAdder
        staticLog(() -> {
            testLongAdder(threadCount, times);
        }, "LongAdder");

        // LongAccumulator
        staticLog(() -> {
            testLongAccumulator(threadCount, times);
        }, "LongAccumulator");
        System.out.println("-------------------- 华丽的分隔线 --------------------");

        // 归零
        num = 0;
    }

    /**
     * 测试 Synchronized
     */
    private static void testSynchronized(int threadCount, int times) {
        try {
            List<Thread> threads = new ArrayList<>();
            CountDownLatch countDownLatch = new CountDownLatch(threadCount);

            for (int i = 0; i < threadCount; i++) {
                threads.add(new Thread(() -> {
                    try {
                        for (int j = 0; j < times; j++) {
                            doSum();
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }));
            }
            for (Thread thread : threads) {
                thread.start();
            }
            countDownLatch.await();
            System.out.println("synchronized结果：" + num);
        } catch (Exception e) {
            //
        }
    }

    private static synchronized void doSum() {
        num++;
    }

    /**
     * 测试 AtomicInteger
     */
    private static void testAtomicInteger(int threadCount, int times) {
        try {
            AtomicInteger atomicInteger = new AtomicInteger();
            List<Thread> threads = new ArrayList<>();
            CountDownLatch countDownLatch = new CountDownLatch(threadCount);
            for (int i = 0; i < threadCount; i++) {
                threads.add(new Thread(() -> {
                    try {
                        for (int j = 0; j < times; j++) {
                            atomicInteger.incrementAndGet();
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }));
            }
            for (Thread thread : threads) {
                thread.start();
            }
            countDownLatch.await();
            System.out.println("atomicInteger结果：" + atomicInteger.get());
        } catch (Exception e) {
            //
        }
    }

    /**
     * 测试 AtomicLong
     */
    private static void testAtomicLong(final int threadCount, final int times) {
        try {
            AtomicLong atomicLong = new AtomicLong();
            List<Thread> threads = new ArrayList<>();
            CountDownLatch countDownLatch = new CountDownLatch(threadCount);
            for (int i = 0; i < threadCount; i++) {
                threads.add(new Thread(() -> {
                    try {
                        for (int j = 0; j < times; j++) {
                            atomicLong.incrementAndGet();
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }));
            }
            for (Thread thread : threads) {
                thread.start();
            }
            countDownLatch.await();
            System.out.println("atomicLong结果：" + atomicLong.get());
        } catch (Exception e) {
            //
        }
    }
    /**
     * 测试 LongAdder
     */
    private static void testLongAdder(int threadCount, int times) {
        try {
            LongAdder longAdder = new LongAdder();
            List<Thread> threads = new ArrayList<>();
            CountDownLatch countDownLatch = new CountDownLatch(threadCount);
            for (int i = 0; i < threadCount; i++) {
                threads.add(new Thread(() -> {
                    try {
                        for (int j = 0; j < times; j++) {
                            longAdder.increment();
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }));
            }
            for (Thread thread : threads) {
                thread.start();
            }
            countDownLatch.await();
            System.out.println("longAdder结果：" + longAdder.longValue());
        } catch (Exception e) {
            //
        }
    }

    /**
     * 测试 LongAccumulator
     */
    private static void testLongAccumulator(int threadCount, int times) {
        try {
            LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x + y, 0);
            List<Thread> threads = new ArrayList<>();
            CountDownLatch countDownLatch = new CountDownLatch(threadCount);
            for (int i = 0; i < threadCount; i++) {
                threads.add(new Thread(() -> {
                    try {
                        for (int j = 0; j < times; j++) {
                            longAccumulator.accumulate(1);
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }));
            }
            for (Thread thread : threads) {
                thread.start();
            }
            countDownLatch.await();
            System.out.println("longAccumulator结果：" + longAccumulator.longValue());
        } catch (Exception e) {
            //
        }
    }

    /**
     * log
     */
    protected static void staticLog(MyConsumer consumer, String name) {
        long start = System.currentTimeMillis();
        consumer.apply();
        long end = System.currentTimeMillis();
        System.out.println(name + " 执行了:" + (end - start) + "ms");
    }
}

@FunctionalInterface
interface MyConsumer {
    // apply
    void apply();
}
