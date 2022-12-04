package com.mayikt.observer.jdk;

/**
 * @author 余胜军
 * @ClassName Test01
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class Test01 {
    public static void main(String[] args) {
        MessageObServable messageObServable = new MessageObServable();
        messageObServable.addObserver(new JdkTextMessageObServer());
        messageObServable.addObserver(new JdkWeChatObServer());
        messageObServable.notifyObservers("mayikt");
    }
    /**
     * 1.反射机制---
     * 2.mybatis源码
     */
}
