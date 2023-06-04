package org.example.juc;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class MyObject{
    @Override
    protected void finalize() throws Throwable{
        //finalize的通常目的是在对象被不可撤销的丢弃之前进行清理操作
        System.out.println("finalize()被调用-------invoke finalize");
    }
}

public class referenceDemo {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        ReferenceQueue<MyObject> referenceQueue = new ReferenceQueue<>();
        PhantomReference<MyObject> phantomReference = new PhantomReference<>(myObject, referenceQueue);
       // System.out.println(phantomReference.get());//这里就是个null--虚引用的get()就是null

        List<byte[]> list = new ArrayList<>();

        new Thread(() -> {
            while (true)//模拟一个无限循环
            {
                list.add(new byte[1 * 1024 * 1024]);
                try { TimeUnit.MILLISECONDS.sleep(600); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(phantomReference.get());
            }
        },"t1").start();

        new Thread(() -> {
            while (true)
            {
                Reference<? extends MyObject> reference = referenceQueue.poll();
                if (reference != null) {
                    System.out.println("有虚对象加入队列了");
                }
            }
        },"t2").start();

    }
}
//null
//finalize()被调用-------invoke finalize
//null
//null
//null
//null
//null
//有虚对象加入队列了  ------(说明被干掉之后进入了这个引用队列)
//Exception in thread "t1" java.lang.OutOfMemoryError: Java heap space
//  at com.zhang.admin.controller.referenceDemo.lambda$main$0(referenceDemo.java:30)
//  at com.zhang.admin.controller.referenceDemo$$Lambda$1/1108411398.run(Unknown Source)
//  at java.lang.Thread.run(Thread.java:748)


