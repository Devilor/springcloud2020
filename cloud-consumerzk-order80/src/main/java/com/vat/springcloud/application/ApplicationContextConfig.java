package com.vat.springcloud.application;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author 东街浊酒づ
 * @date 2020/7/6
 */
@SpringBootConfiguration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced //开启负载均衡机制
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
