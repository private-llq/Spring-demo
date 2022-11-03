package org.example.se;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.se
 * @date 2022/10/26 23:03
 * @Copyright i++ 与 ++i的区别
 */
public class iTest {
    public static void main(String[] args) {

        int i = 0;
        int m = add(i++);
        i = 0;
        m = add(0);
        i = i + 1;


        int n = add(++i);
        i = i + 1;
        add(i);

        System.out.println("m的值：" + m);
        System.out.println("n的值：" + n);
        System.out.println("i的值：" + i);


    }

    public static int add(int p) {
        p = p + 10;
        return p;
    }
}
