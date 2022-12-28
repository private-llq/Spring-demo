package org.example.se;

import java.util.Scanner;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.se
 * @date 2022/12/27 23:42
 * @description: Scanner类
 */
public class ScannerTest {
    public static void main(String[] args) {
        /*//从键盘接收数据
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");//修改输入数据的分隔符
        System.out.println("输出数据");
        String next = scanner.next();
        System.out.println("输出的数据为："+next);*/

        Scanner scan = new Scanner(System.in);//从键盘接收数据
        int i=0;
        float j=0;
        System.out.print("输入整数：");
        if (scan.hasNextInt()) {//判断输入的是否是整数
            i = scan.nextInt();//接收整数
            System.out.println("整数数据：" + i);
        }
        System.out.print("输入小数：");
        if (scan.hasNextFloat()) {//判断输入的是否是小数
            j = scan.nextFloat();//接收小数
            System.out.println("小数数据：" + j);
        }
    }
}
