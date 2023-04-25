package org.example.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author llq
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call(){
        System.out.println("和小刘一个月学透JUC");
        return "返回值";
    }

    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        Thread myThread = new Thread(futureTask, "线程2");
        myThread.start();
        try {
            System.out.println("线程的返回值：" + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}