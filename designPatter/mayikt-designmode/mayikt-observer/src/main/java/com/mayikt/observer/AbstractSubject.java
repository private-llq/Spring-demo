package com.mayikt.observer;

/**
 * @author 余胜军
 * @ClassName AbstractSubject
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public interface AbstractSubject {
    /**
     * 新增观察者对象存入到集合中
     *
     * @param obServer
     */
    void addObServer(ObServer obServer);

    /**
     * 删除某个观察者对象
     *
     * @param obServer
     */
    void delObServer(ObServer obServer);

    /**
     * 通知所有的观察者
     */
    void notifyAllObServer(String message);
}
