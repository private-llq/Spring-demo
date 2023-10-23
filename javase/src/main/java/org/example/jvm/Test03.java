package org.example.jvm;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.jvm
 * @date 2023/10/12 0:13
 * @description: 公司
 */
public class Test03 {
    private volatile boolean flag = false;

    public void start() {
        new Thread(() -> {
            System.out.println("Thread A: Starting");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("Thread A: Flag is set to true");
        }).start();

        new Thread(() -> {
            System.out.println("Thread B: Waiting for flag to become true");
            while (!flag) {
                // Busy wait until flag becomes true​
            }
            System.out.println("Thread B: Flag is now true");
        }).start();
    }

    public static void main(String[] args) {
        Test03 example = new Test03();
        example.start();
    }
}
