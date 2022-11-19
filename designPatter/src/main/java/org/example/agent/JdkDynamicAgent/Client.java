package org.example.agent.JdkDynamicAgent;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.agent.JdkDynamicAgent
 * @date 2022/11/14 21:53
 * @description: 动态代理测试
 */
public class Client {

    public static void main(String[] args) {
        //获取代理对象
        ProxyFactory factory = new ProxyFactory();

        SellTickets proxyObject = factory.getProxyObject();
        proxyObject.sell();
    }
}
