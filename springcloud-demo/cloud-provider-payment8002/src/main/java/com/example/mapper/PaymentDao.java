//PaymentDao
package com.example.mapper;
import com.example.doamin.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    Integer create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
