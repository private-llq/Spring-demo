package org.example.test;

public class CurrentFrameTest{
    public static void main(String[] args) {
        methodA();
    }
    public static void methodA(){
        System.out.println("当前栈帧对应的方法->methodA");
        methodB();
        System.out.println("当前栈帧对应的方法->methodA");
    }
    public static void methodB(){
        System.out.println("当前栈帧对应的方法->methodB");
    }
}