package org.example.jvm;


import cn.hutool.core.date.DateUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.jvm
 * @date 2023/10/23 13:01
 * @description: 公司
 */
public class Singleton {
    private static volatile Singleton instance;


    private Singleton() {
        // 私有构造函数
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 34, 5);
        Singleton instance = getInstance();
        Double d  = new Double(1);
        System.out.println(instance);
        char c = 'a';
        short s = 1;
        byte f = 1;
        System.out.println(d + ":3:" + c + ":2:"  + s  + ":1:"+ f);
        Date date = new Date();
        System.out.println(DateUtil.format(date,"yyyy-MM-dd HH:mm:ss"));
    }
}
