package org.example.jvm;

public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("hello  world");
        short[] a= {1,2,3,4};
        load(1,1,1,true,a);

    }
    public static void load(int num, Object obj, long count, boolean flag, short[] arr) {
        System.out.println(num);
        System.out.println(obj);
        System.out.println(count);
        System.out.println(flag);
        System.out.println(arr);
    }
}
