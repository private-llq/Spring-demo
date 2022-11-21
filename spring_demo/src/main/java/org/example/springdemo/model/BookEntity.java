package org.example.springdemo.model;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package org.example.springdemo.model
 * @date 2022/11/21 21:42
 * @description: 公司
 */
public class BookEntity {
    private String orderId;
    private String orderName;

    public BookEntity(String orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
        System.out.println("反射机制执行到"+orderId+":"+orderName);
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "orderId='" + orderId + '\'' +
                ", orderName='" + orderName + '\'' +
                '}';
    }
}
