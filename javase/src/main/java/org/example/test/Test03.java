package org.example.test;

/**
 * @author liuliangqi
 * @date 2023/1/16 8:47
 */
public class Test03 {
    /**
     * 在以下4种特殊情况下，finally块不会被执行
     * 1.在finally语句块中发生了异常
     * 2.在前面的代码中用了System.exit（）退出程序
     * 3.程序所有线程死亡
     * 4.关闭CPU
     *
     * @param args
     */
    public static void main(String[] args) {
       /* System.out.println("执行try前");
        boolean flag=true;
        *//*if (flag){
            return;
        }*//*
        try {
            System.out.println("执行try块");
        }catch (Exception e){
            e.printStackTrace();
            int i =1/0;
            System.out.println("catchz执行");
        }finally {
                System.out.println("finally执行");

        }*/


        //情况一：
        //        try {
        //            System.out.println("try执行了");
        //            int i =1/0;
        //        }catch (Exception e){
        //            e.printStackTrace();
        //            System.out.println("catch执行了");
        //        }finally {
        //            System.out.println("finally执行了");
        //        }


        //情况二：
        //        try {
        //            System.out.println("try执行了");
        //            return;
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //            System.out.println("catch执行了");
        //        } finally {
        //            System.out.println("finally执行了");
        //        }
        //        系统类exit()方法exit()方法在java.lang包中可用。

        //情况三：
        try {
            System.out.println("try执行了");
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch执行了");
        } finally {
            System.out.println("finally执行了");
        }
    }

}
