package org.example.jvm;

import java.math.BigDecimal;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.jvm
 * @date 2023/8/8 21:40
 * @description: 公司
 */
public class Test02 {
    public void ThreadPoolExecutor(int corePoolSize,
                                   int maximumPoolSize,
                                   long keepAliveTime,
                                   TimeUnit unit,
                                   BlockingQueue<Runnable> workQueue,
                                   ThreadFactory threadFactory,
                                   RejectedExecutionHandler handler){
    }
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(3);
        System.out.println(bigDecimal.add(bigDecimal));
    }
}
