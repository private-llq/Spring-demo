package org.example.juc;

/**
 * 验证指令重排的案例
 * 顺序执行下，x和y不可能同时为0，如果出现了同时为0，则说明发生了指令重排。
 * @author llq
 */
public class InstructionRearrangement {
    static int a = 0, b = 0, x = 0, y = 0;

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread one = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread other = new Thread(() -> {
                b = 1;
                y = a;
            });
            one.start();
            other.start();
            one.join(); //等待线程 one 执行完毕
            other.join();
            //没有指令重排，x和y不可能同时为0
            if (x == 0 && y == 0) {
                System.out.println("x=" + x + ",y=" + y);
            }
            a = 0;
            b = 0;
            x = 0;
            y = 0;
        }
    }
}