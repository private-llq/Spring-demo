package org.example.se;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.se
 * @date 2024/5/11 12:51
 * @description: 公司
 */
public class Thread1 {


    public ThreadPoolExecutor getThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
                                                    long keepAliveTime, TimeUnit unit,
                                                    BlockingQueue<Runnable> workQueue) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println("hello  world");
    }
}
