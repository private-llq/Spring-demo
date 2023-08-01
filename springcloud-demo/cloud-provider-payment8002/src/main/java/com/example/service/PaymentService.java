package com.example.service;

import com.example.doamin.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package com.example.service
 * @date 2023/8/1 20:52
 * @description: 公司
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
