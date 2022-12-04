package com.mayikt.proxy02;

import com.mayikt.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 余胜军
 * @ClassName OrderServiceProxy
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
@Slf4j
public class OrderServiceProxy extends OrderServiceImpl {
    // 让我们代理类 继承 被代理类
    //

    @Override
    public String addOrder(String orderName) {
        log.info("<在addorder方法之前处理  orderName:{}>", orderName);
        String result = super.addOrder(orderName);
        log.info("<在addorder方法之后处理  orderName:{}>", orderName);
        return result;
    }
    /**
     * 属于静态代理 -开发者是需要编写 代理类呢 代码非常的冗余
     * 如果当前有几百个 需要被代理的类----几百个代理类
     * 动态代理-----程序方式自动生产代理类（反射、编译class、字节码技术）
     */
}
