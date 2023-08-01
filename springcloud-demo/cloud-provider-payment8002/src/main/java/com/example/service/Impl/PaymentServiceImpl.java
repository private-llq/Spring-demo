package com.example.service.Impl;

import com.example.doamin.Payment;
import com.example.dto.CommonResult;
import com.example.mapper.PaymentDao;
import com.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package com.example.service.Impl
 * @date 2023/8/1 20:53
 * @description: 公司
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
