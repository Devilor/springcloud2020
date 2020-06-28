package com.vat.springcloud.controller;

import com.vat.springcloud.entities.CommonResult;
import com.vat.springcloud.entities.Payment;
import com.vat.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 东街浊酒づ
 * @date 2020/6/27
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/vat/insertPayment")
    public CommonResult insertPayment(Payment payment) {
        int result = this.paymentService.insertPayment(payment);
        log.info("插入结果:{}", result);
        if (result > 0) {
            return new CommonResult(200, "插入成功！", payment);
        }
        return new CommonResult(999, "插入失败");
    }

    @GetMapping(value = "/vat/selectById/{id}")
    public CommonResult selectById(@PathVariable("id") Long id) {
        Payment payment = this.paymentService.selectById(id);
        log.info("查询结果:[{}]", payment);
        if (null == payment) {
            return new CommonResult(999, "查询失败！");
        }
        return new CommonResult(999, "查询成功！", payment);
    }
}
