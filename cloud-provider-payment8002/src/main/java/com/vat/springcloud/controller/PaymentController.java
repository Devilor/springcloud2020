package com.vat.springcloud.controller;

import com.vat.springcloud.entities.CommonResult;
import com.vat.springcloud.entities.Payment;
import com.vat.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/vat/insertPayment")
    public CommonResult insertPayment(@RequestBody Payment payment) {
        int result = this.paymentService.insertPayment(payment);
        log.info("插入结果:{}", result);
        if (result > 0) {
            return new CommonResult(200, "插入成功！", result);
        }
        return new CommonResult(999, "插入失败,ServerPort:" + serverPort);
    }

    @GetMapping(value = "/vat/selectById/{id}")
    public CommonResult selectById(@PathVariable("id") Long id) {
        Payment payment = this.paymentService.selectById(id);
        log.info("查询结果:[{}]", payment);
        if (null == payment) {
            return new CommonResult(999, "查询失败！");
        }
        return new CommonResult(999, "查询成功！ServerPort:" + serverPort, payment);
    }
}
