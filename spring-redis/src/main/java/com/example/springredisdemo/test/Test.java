package com.example.springredisdemo.test;


import cn.hutool.core.date.DateUtil;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package com.example.springredisdemo.test
 * @date 2022/10/16 16:43
 * @Copyright 公司
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                System.out.println(Utils.get());
            }).start();
        }
    }


    static class Utils{
        private static final ThreadLocal<ReentrantLock> THREAD_LOCAL = new ThreadLocal<>();

        static ReentrantLock get(){
            ReentrantLock reentrantLock = THREAD_LOCAL.get();
            if(reentrantLock!=null){
                return reentrantLock;
            }
            reentrantLock = new ReentrantLock();
            THREAD_LOCAL.set(reentrantLock);
            return reentrantLock;
        }
    }


}