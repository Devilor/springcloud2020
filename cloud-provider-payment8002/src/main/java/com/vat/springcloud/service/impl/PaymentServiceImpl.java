package com.vat.springcloud.service.impl;

import com.vat.springcloud.dao.PaymentDao;
import com.vat.springcloud.entities.Payment;
import com.vat.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 东街浊酒づ
 * @date 2020/6/27
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int insertPayment(Payment payment) {
        return paymentDao.insertPayment(payment);
    }

    @Override
    public Payment selectById(Long id) {
        return paymentDao.selectById(id);
    }
}
