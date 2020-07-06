package com.vat.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author 东街浊酒づ
 * @date 2020/7/2
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/zk")
    public String paymentZk() {
        return "SpringCloud With Zookeeper : " + serverPort + UUID.randomUUID().toString();
    }
}
