package org.example.springdemo.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.service.proxy
 * @date 2022/12/3 20:00
 * @description: 公司
 */
public class MkInvcationHandler implements InvocationHandler {
    /**
     * 目标对象
     */
    private Object target;


    public MkInvcationHandler(Object target){
        this.target = target;
    }
    /**
     * 参数1：Object proxy JDK自动生成代理类
     * 参数2：目标对象的接口
     * 参数3：目标对象的接口，需要参数值
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("目标方法之前执行"+args);
        Object result = method.invoke(target, args);
        System.out.println("目标方法之后执行"+args);
        return result;
    }

    /**
     * 参数1：类加载器 传递 目标对象的类加载器
     * 参数2：目标对象实现的接口
     * JDK动态代理底层 生成的代理类  实现该接口
     * @param <T>
     * @return
     */
    //底层 帮助自动生成代理类
    public <T> T getProxy(){
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

}
