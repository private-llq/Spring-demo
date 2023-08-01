package com.example.controller;

import com.example.doamin.Payment;
import com.example.dto.CommonResult;
import com.example.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liuliangqi
 * @version V1.0
 * @Package com.example.controller
 * @date 2023/8/1 20:58
 * @description: 公司
 */
@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    //只传给前端CommonResult，不需要前端了解其他的组件
    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(Payment payment) {
        int result = paymentService.create(payment);
        //log.info("*****插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功", result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        //log.info("*****插入结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID：" + id, null);
        }
    }
}
