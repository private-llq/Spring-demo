package org.example.juc;

/**
 * @author llq
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("和小刘一个月学透JUC");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread myThread = new Thread(myRunnable, "线程2");
        myThread.start();
    }
}