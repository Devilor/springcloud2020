package com.vat.springcloud.service;

import com.vat.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 东街浊酒づ
 * @date 2020/6/27
 */
public interface PaymentService {
    public int insertPayment(Payment payment);

    public Payment selectById(@Param("id") Long id);
}
