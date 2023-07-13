package org.example.test;

public class Test07 {
    private static ThreadLocal<String> threadLocal =new ThreadLocal<>();
    static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + threadLocal.get());
        //清除本地内存中的本地变量
        threadLocal.remove();
    }
    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Test07.threadLocal.set("local_A");
                print("A");
                //打印本地变量
                System.out.println("after remove : " + threadLocal.get());

            }
        },"A").start();

        Thread.sleep(1000);


        new Thread(new Runnable() {
            @Override
            public void run() {
                Test07.threadLocal.set("local_B");
                print("B");
                System.out.println("after remove : " + threadLocal.get());
            }
        },"B").start();
    }
}
