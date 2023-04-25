package org.example.juc;

/**
 * @author llq
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("和小刘一个月学透JUC");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setName("线程1");
        myThread.start();
    }
}