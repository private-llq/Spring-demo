package org.example.juc;

import java.util.concurrent.*;

/**
 * @author liuliangqi
 * @date 2023/4/25 16:04
 */
public class Pool {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 提交任务到线程池
        executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("线程1：" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("线程2：" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 关闭线程池
        executorService.shutdown();
    }

    static class Pools {
        public static void main(String[] args) {
            // 创建线程池
            ThreadPoolExecutor executor = new ThreadPoolExecutor(
                    2, // 核心线程数
                    10, // 最大线程数
                    60L, // 线程空闲时间
                    TimeUnit.SECONDS, // 时间单位
                    new LinkedBlockingQueue<Runnable>(100)); // 阻塞队列

            // 提交任务到线程池
            executor.submit(() -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println("线程1：" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            executor.submit(() -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println("线程2：" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            // 关闭线程池
            executor.shutdown();
        }
    }
}
