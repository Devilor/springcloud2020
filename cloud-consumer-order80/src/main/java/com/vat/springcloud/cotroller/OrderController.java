package com.vat.springcloud.cotroller;

import com.vat.springcloud.entities.CommonResult;
import com.vat.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 东街浊酒づ
 * @date 2020/6/28
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/insert")
    public CommonResult<Integer> insertPayment(Payment payment) {
        log.info("消费者调用服务 ==> insert");
        return restTemplate.postForObject(PAYMENT_URL + "/vat/insertPayment", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/select/{id}")
    public CommonResult<Payment> selectById(@PathVariable("id") Long id) {
        log.info("消费者调用服务 ==> select");
        return restTemplate.getForObject(PAYMENT_URL + "/vat/selectById/" + id, CommonResult.class);
    }
}
