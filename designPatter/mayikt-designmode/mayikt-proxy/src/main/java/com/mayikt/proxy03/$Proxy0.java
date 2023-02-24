package com.mayikt.proxy03;

import com.mayikt.service.OrderService;
import com.mayikt.service.impl.OrderServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * @author 余胜军
 * @ClassName $Proxy0
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class $Proxy0 extends Proxy implements OrderService {
    /**
     * 当我们静态代码快在执行的时候 初始化 根据反射技术获取这些方法
     */
    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            m3 = Class.forName("com.mayikt.service.OrderService").getMethod("addOrder", Class.forName("java.lang.String"));
            m2 = Class.forName("java.lang.Object").getMethod("toString");
            m0 = Class.forName("java.lang.Object").getMethod("hashCode");
        } catch (NoSuchMethodException var2) {
            throw new NoSuchMethodError(var2.getMessage());
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }
    }
    /**
     * jdk生成代理类
     */
    /**
     * Object 中的Object
     */
    private static Method m1;
    /**
     * OrderService 目标对象实现的接口方法 addOrder
     */
    private static Method m3;
    /**
     * Object  toString
     */
    private static Method m2;
    /**
     * Object hashCode
     */
    private static Method m0;

    /**
     * 通过有参构造方法传递 InvocationHandler实现类
     *
     * @param var1 this.h = h; h=MayiktInvocationHandler
     */
    public $Proxy0(InvocationHandler var1) {
        super(var1);
    }

    public final String addOrder(String var1) {
        try {
            return (String) super.h.invoke(this, m3, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    public final boolean equals(Object var1) {
        try {
            return (Boolean) super.h.invoke(this, m1, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }


    public final String toString() {
        try {
            return (String) super.h.invoke(this, m2, (Object[]) null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final int hashCode() {
        try {
            return (Integer) super.h.invoke(this, m0, (Object[]) null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public static void main(String[] args) {
        $Proxy0 $Proxy0 = new $Proxy0(new MayiktInvocationHandler(new OrderServiceImpl()));
        $Proxy0.addOrder("mayikt");
    }

}

