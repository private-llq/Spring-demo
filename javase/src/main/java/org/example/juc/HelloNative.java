package org.example.juc;

/**
 * @author llq
 */
public class HelloNative {
    static {
        // 注意加载库的名字为 HelloNative，需要与下文的生成文件保持一致
        System.loadLibrary("HelloNative");
    }
     
    public static native void sayHello();
     
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        new HelloNative().sayHello();
    }
}
