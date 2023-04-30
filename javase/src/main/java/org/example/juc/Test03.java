package org.example.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.juc
 * @date 2023/4/30 11:28
 * @description: 公司
 */
public class Test03 {
    public static void main(String[] args) {
        //实现Callable接口 + FutureTask （可以拿到返回结果，可以处理异常）
        FutureTask<Integer> futureTask = new FutureTask<>(new Test03.callableTest());
        new Thread(futureTask).start();
    }
    // 实现Callable接口 （可以拿到返回结果，可以处理异常）
    public static class callableTest implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("当前线程："+Thread.currentThread().getId());
            System.out.println("---------");
            System.out.println("C1");
            return 66;
        }
    }
}
