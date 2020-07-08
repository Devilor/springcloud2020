package com.vat.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 东街浊酒づ
 * @date 2020/7/8
 */
@RestController
@Slf4j
public class OrderConsulController {

    private final static String INVOKE_URL = "http://consul-provider-payment";

    @Value("${server.port}")
    private String serverPort;

    /**
     * 注入 RestTemplate
     */
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/vat/consul/payment")
    public String getInfo() {
        return restTemplate.getForObject(INVOKE_URL + "/vat/payment/consul", String.class);
    }

}
