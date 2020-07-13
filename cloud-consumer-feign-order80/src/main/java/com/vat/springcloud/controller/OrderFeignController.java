package com.vat.springcloud.controller;

import com.vat.springcloud.entities.CommonResult;
import com.vat.springcloud.entities.Payment;
import com.vat.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 东街浊酒づ
 * @date 2020/7/15
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/vat/selectById/{id}")
    public CommonResult<Payment> selectById(@PathVariable(value = "id") Long id) {
        return this.paymentFeignService.selectById(id);
    }

    @GetMapping(value = "/consumer/vat/feign/timeout")
    public String paymentFeignTimeout() {
        return this.paymentFeignService.paymentFeignTimeout();
    }
}
