package com.mayikt.proxy03;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 余胜军
 * @ClassName MayiktInvocationHandler
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Slf4j
public class MayiktInvocationHandler implements InvocationHandler {
    /**
     * 目标对象
     */
    private Object target;

    public MayiktInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 参数1：Object proxy JDK自动生成代理类
     * 参数2：目标对象的接口
     * 参数3：目标对象的接口 需要参数值
     * OrderService.addOrder();
     * -----MayiktInvocationHandler.invoke();
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //参数 那个对象中 该方法 该方法的时候传递参数值
        log.info("<目标方法之前执行....args：{}>", args);
        Object result = method.invoke(target, args);// 底层基于java反射机制调用 该对象中 该方法
        log.info("<目标方法之后执行....args：{}>", args);
        return result;
    }
    // 底层 帮助自动生成代理类

    /**
     * 参数1：类加载器 传递 目标对象的类加载器
     * 参数2：目标对象实现的接口
     * JDK动态代理底层 生成的代理类  实现该接口
     *
     * @param <T> 传递 目标对象
     * @return
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                this);
    }
}
