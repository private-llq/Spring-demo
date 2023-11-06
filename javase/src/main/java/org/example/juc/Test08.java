package org.example.juc;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.juc
 * @date 2023/11/3 14:46
 * @description: 公司
 */
public class Test08  {
    public static void main(String[] args) {
        int a = 0;
        int c = 0;
        do {
            --c;
            a = a - 1;
        } while (a > 0);
        System.out.println(c);

    }
}
