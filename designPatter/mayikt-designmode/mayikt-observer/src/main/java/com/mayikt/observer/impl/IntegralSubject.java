package com.mayikt.observer.impl;

import com.mayikt.observer.AbstractSubject;
import com.mayikt.observer.ObServer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 余胜军
 * @ClassName IntegralSubject
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class IntegralSubject implements AbstractSubject {
    private List<ObServer> obServers = new ArrayList<>();

    @Override
    public void addObServer(ObServer obServer) {
        obServers.add(obServer);
    }

    @Override
    public void delObServer(ObServer obServer) {
        obServers.remove(obServer);
    }

    @Override
    public void notifyAllObServer(String message) {
        obServers.forEach((o) -> {
            o.update(message);
        });
        //java反射机制 获取 obServer下有哪些实现类
        //java反射机制 调用每个实现类中 update(message)
    }
}

