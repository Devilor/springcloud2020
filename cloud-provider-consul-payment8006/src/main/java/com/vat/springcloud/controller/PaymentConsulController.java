package com.vat.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author 东街浊酒づ
 * @date 2020/7/7
 */
@RestController
@Slf4j
public class PaymentConsulController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/vat/payment/consul")
    public String info() {
        return "<strong>SringCloud-Consul:Server Port=>" + serverPort + UUID.randomUUID().toString() + "</strong>";
    }
}
