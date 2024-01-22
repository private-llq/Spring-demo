package com.llq;

public class Parent {

    public void call() {
        System.out.println("im Parent");
    }
}

class Son extends Parent {// 1.有类继承或者接口实现

    @Override
    public void call() {// 2.子类要重写父类的方法
        System.out.println("im Son");
    }
}

class Daughter extends Parent {// 1.有类继承或者接口实现

    @Override
    public void call() {// 2.子类要重写父类的方法
        System.out.println("im Daughter");
    }
}

class Test {

    public static void main(String[] args) {
        Parent p = new Son(); //3.父类的引用指向子类的对象
        Parent p1 = new Daughter(); //3.父类的引用指向子类的对象
    }
}