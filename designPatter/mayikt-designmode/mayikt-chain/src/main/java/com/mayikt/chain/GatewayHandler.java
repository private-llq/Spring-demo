package com.mayikt.chain;

/**
 * @author 余胜军
 * @ClassName GatewayHandler
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public abstract class GatewayHandler {
    /**
     * 下一个 nextGatewayHandler
     */
    protected GatewayHandler nextGatewayHandler;

    /**
     * doService 处理流程
     */
    public abstract void doService () throws Exception;

    /**
     * 设置当前的Handler 下一个Handler
     */
//    public abstract void setNextGatewayHandler(GatewayHandler nextGatewayHandler);

//    @Override

    /**
     * 设置当前的Handler 下一个Handler
     */
    public void setNextGatewayHandler(GatewayHandler nextGatewayHandler) {
        this.nextGatewayHandler = nextGatewayHandler;
    }
}
