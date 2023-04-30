package org.example.juc;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.juc
 * @date 2023/4/30 11:22
 * @description: 公司
 */
public class Runnable01 {
    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        new Thread(runnableTest).start();
    }

    // 实现Runnable接口
    public static class RunnableTest implements Runnable{
        @Override
        public void run(){
            System.out.println("当前线程："+Thread.currentThread().getId());
            System.out.println("----------");
            System.out.println("R1");
        }

    }
}
