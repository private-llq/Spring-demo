package org.example.juc;

import net.sf.jsqlparser.statement.select.KSQLWindow;

import java.util.concurrent.TimeUnit;


/**
 * @author liulq
 */
public class DaemonDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 开始运行," + (Thread.currentThread().isDaemon() ? "守护线程" : "用户线程"));
            while (true) {

            }
        }, "t1");
        t1.setDaemon(true);//通过设置属性Daemon来设置当前线程是否为守护线程
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 主线程结束");
    }
}


//输出：t1 开始运行,守护线程
//main 主线程结束--->在main主线程结束后，守护线程会伴随着JVM一同结束工作，即使还有循环没有结束
