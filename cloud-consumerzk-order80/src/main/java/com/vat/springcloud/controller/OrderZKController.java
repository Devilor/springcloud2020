package com.vat.springcloud.controller;

import com.sun.scenario.effect.InvertMask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 东街浊酒づ
 * @date 2020/7/6
 */
@Slf4j
@RestController
public class OrderZKController {
    private final static String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/vat/consumer/payment/zk")
    public String paymentInfo() {
        if (log.isInfoEnabled()) {
            log.info("Zookeeper...");
        }
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    }
}
