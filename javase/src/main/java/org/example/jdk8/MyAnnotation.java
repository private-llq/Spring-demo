package org.example.jdk8;


public @interface MyAnnotation {
    String name() default "zhangsan";
    String[] nums();
    int age() default 11;
    double price();
}
