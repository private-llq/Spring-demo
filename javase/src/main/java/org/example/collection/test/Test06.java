package org.example.collection.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import static jdk.nashorn.internal.objects.Global.print;

public class Test06 {
    public static void useCompletableFuture_complicated() {
        // 这个方法时描述一般地使用CompletableFuture实现异步操作，即复杂的使用CompletableFuture实现异步操作

        // 假设我们有一个Person名字List
        List<String> personNameList = new ArrayList<>();

        // 为了方便测试，我们要构造大量的数据add到personNameList，用for循环，名字就是1, 2, 3, ...

        // 这里添加1000个名字到personNameList
        for (int i = 0; i < 1000; i++) {
            personNameList.add(String.valueOf(i));
        }

        // 假设我们要做的业务是personNameList里的每个人都说一句Hello World, 但是我们不关心他们说这句话的顺序，而且我们希望这个业务能够较快速的完成，所以采用异步就是比较合适的

        // 先创建两个活动线程的线程池
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 开始我们的业务处理
        for (String personName : personNameList) {
            CompletableFuture.supplyAsync(new Supplier<String>() {
                @Override
                public String get() {
                    // 模拟业务逻辑，say hello world
                    System.out.println(personName + ": Hello World!");
                    return "task finished!";
                }
            }, executor);
        }

        // 关闭线程池executor
        // 说明一下executor必须要显示关闭（它的方法里有介绍），不然线程池会一直等待任务，会导致main方法一直运行
        // 还有就是关闭executor，不会导致之前提交的异步任务被打断或者取消。即之前提交的任务依然会执行到底，只是不会再接收新的任务
        executor.shutdown();

        /* 那么关闭线程池之后，我们怎么确定我们的任务是否都完成了呢，可以使用executor.isTerminated()命令
        // 可以看看isTerminated这个方法的说明，简单的说就是调用isTerminated()方法之前没有调用shutdown()方法的话，那么isTerminated()方法返回的永远是false。
        // 所以isTerminated()方法返回true的情况就是在调用isTerminated()方法之前要先调用shutdown()方法，且所有的任务都完成了。
        // 其实调用isTerminated()的目的就是我们对异步任务的结果是care, 我们需要等待异步任务的结果以便我们做下一步的动作。
        // 如果我们不关心异步任务的结果的话，完全可以不用调用isTerminated()。
        */
        while (!executor.isTerminated()) {
            System.out.println("no terminated");
            try {
                System.out.println("我要休眠一下");
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public static void useCompletableFuture_simple() {
        // 这个方法时描述利用1.8新特性，简单使用CompletableFuture实现异步操作

        // 先创建两个活动线程的线程池
        ExecutorService executor = Executors.newFixedThreadPool(2);

        List<String> nameList = new ArrayList<String>();

        for (int i = 0; i < 1000; i++) {
            nameList.add(String.valueOf(i));
        }

        // 使用JDK 1.8的特性，stream()和Lambda表达式: (参数) -> {表达式}
        nameList.stream().forEach(name -> CompletableFuture.supplyAsync((Supplier<String>) () -> {
            print((String) name); // 封装了业务逻辑
            return "success";
        }, executor).exceptionally(e -> {
            System.out.println(e);
            return "false";
        }));

        executor.shutdown();

        while (!executor.isTerminated()) {
            System.out.println("no terminated");
            try {
                System.out.println("我要休眠一下");
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        useCompletableFuture_simple();
    }
}
