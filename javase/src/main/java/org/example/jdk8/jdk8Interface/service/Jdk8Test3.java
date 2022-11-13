package org.example.jdk8.jdk8Interface.service;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.jdk8.jdk8Interface.service
 * @date 2022/11/13 15:46
 * @description: jdk8有参
 */
public class Jdk8Test3 {
    public static void main(String[] args) {
        String str = new YouShenInterface() {
            @Override
            public String get(int i, int j) {
                return i + "====" + j;
            }
        }.get(1, 2);
        System.out.println(str);

        //lamdba写法
        YouShenInterface youShenInterface=(i,j)->{
            return i+"====="+j;
        };
        System.out.println(youShenInterface.get(2,3));
    }
}
