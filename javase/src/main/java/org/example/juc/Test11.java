package org.example.juc;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.juc
 * @date 2023/11/9 10:47
 * @description: 公司
 */
public class Test11 {
    //锁
    private static Object lock = new Object();

    static int startNum = 0;
    static int endNum = 10;

    public static void main(String[] args) {

        ThreadPrint[] arr = new ThreadPrint[endNum];
        //不按打印顺序创建线程
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = new ThreadPrint(i);
            arr[i].start();
        }
    }

    private static class ThreadPrint extends Thread {

        private int printNum;   //获取自己需要打印的数字

        ThreadPrint(int printNum) {
            this.printNum = printNum;
        }

        @Override
        public void run() {
            synchronized (lock) {

                while (startNum < endNum) {
                    if (startNum == printNum) {

                        System.out.print(printNum);
                        startNum++;

                        if (startNum == endNum) {
                            System.out.print("\n打印结束");
                        }
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            //线程被打断
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
    }
}
