package com.mayikt.observer.jdk;

import java.util.Observable;

/**
 * @author 余胜军
 * @ClassName MessageObServable
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class MessageObServable extends Observable {
    @Override
    public void notifyObservers(Object arg) {
        //1.发送数据变更
        setChanged();
        //2.通知给每个观察者
        super.notifyObservers(arg);
    }
}
