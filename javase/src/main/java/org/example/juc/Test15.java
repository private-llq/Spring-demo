package org.example.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.juc
 * @date 2023/11/13 19:05
 * @description: 公司
 */
public class Test15 {
    public static void main(String[] args) {
        int a = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(a);
        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            int finalI = i;
            tasks.add(() -> compute(finalI)); // 创建计算任务
        }

        try {
            List<Future<Integer>> futures = executorService.invokeAll(tasks);

            int sum = 0;
            for (Future<Integer> future : futures) {
                sum += future.get(); // 获取计算结果并累加
            }
            System.out.println("Sum: " + sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    private static int compute(int num) {
        // 执行计算任务
        return num * num;
    }
}
