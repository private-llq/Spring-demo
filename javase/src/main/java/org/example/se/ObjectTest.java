package org.example.se;



/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.se
 * @date 2022/10/22 0:06
 * @Copyright
 *
 *
 *
 */
public class ObjectTest implements Cloneable{

    public static void main(String[] args) {
        char c1 ='a',c2 ='b',c3='c',c4='\101',c5='\116';
        int count=0;
        System.out.println(count<<c1<<c2<<c3<<'\n');
        System.out.println(count<<'\t'<<c4<<c5);

        System.out.println(count);
    }
}
