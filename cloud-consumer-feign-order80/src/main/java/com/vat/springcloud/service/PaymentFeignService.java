package com.vat.springcloud.service;

import com.vat.springcloud.entities.CommonResult;
import com.vat.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 东街浊酒づ
 * @date 2020/7/15
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/vat/selectById/{id}")
    CommonResult<Payment> selectById(@PathVariable(value = "id") Long id);

    @GetMapping(value = "/vat/feign/timeout")
    String paymentFeignTimeout();

}
