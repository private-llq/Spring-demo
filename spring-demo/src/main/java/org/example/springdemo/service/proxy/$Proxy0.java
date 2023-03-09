package org.example.springdemo.service.proxy;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.service.proxy
 * @date 2022/12/3 20:57
 * @description: 公司
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import org.example.springdemo.service.OrderService;
import org.example.springdemo.service.impl.OrderServiceImpl;

public final class $Proxy0 extends Proxy implements OrderService {

    private static Method m1;
    private static Method m3;
    private static Method m2;
    private static Method m0;

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            m3 = Class.forName("org.example.springdemo.service.OrderService").getMethod("addOrder", Class.forName("java.lang.String"));
            m2 = Class.forName("java.lang.Object").getMethod("toString");
            m0 = Class.forName("java.lang.Object").getMethod("hashCode");
        } catch (NoSuchMethodException var2) {
            throw new NoSuchMethodError(var2.getMessage());
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }
    }

    public $Proxy0(InvocationHandler var1)   {
        super(var1);
    }

    @Override
    public final boolean equals(Object var1)   {
        try {
            return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    @Override
    public final String addOrder(String var1)   {
        try {
            return (String)super.h.invoke(this, m3, new Object[]{var1});
        } catch (RuntimeException | Error var3) {
            throw var3;
        } catch (Throwable var4) {
            throw new UndeclaredThrowableException(var4);
        }
    }

    @Override
    public final String toString()   {
        try {
            return (String)super.h.invoke(this, m2, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    @Override
    public final int hashCode()   {
        try {
            return (Integer)super.h.invoke(this, m0, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public static void main(String[] args) {
        $Proxy0 $Proxy0 = new $Proxy0(new MkInvcationHandler(new OrderServiceImpl()));
        $Proxy0.addOrder("liuliangqi");
    }
}

