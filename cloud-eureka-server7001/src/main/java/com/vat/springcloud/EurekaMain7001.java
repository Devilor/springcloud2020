package com.vat.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 东街浊酒づ
 * @date 2020/6/29
 */
@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
        log.info("Eureka Server 启动成功！");
    }
}
