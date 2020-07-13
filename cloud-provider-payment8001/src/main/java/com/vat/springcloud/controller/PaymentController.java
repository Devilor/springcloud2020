package com.vat.springcloud.controller;

import com.vat.springcloud.entities.CommonResult;
import com.vat.springcloud.entities.Payment;
import com.vat.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 东街浊酒づ
 * @date 2020/6/27
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    /**
     * 服务发现 Bean
     */
    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping(value = "/vat/discovery")
    public Object discovery() {
        //注册的服务-provider 获取注册中心的注册信息
        List<String> services = this.discoveryClient.getServices();
        for (int i = 0, size = services.size(); i < size; i++) {
            log.info("Provider,Server Port:{},获取注册中心的服务信息：{}", this.serverPort, services.get(i));
        }
        //根据某个在 Eureka 中注册的服务，获取该服务的配置信息，这里以“CLOUD-PAYMENT-SERVICE”注册的服务为例
        List<ServiceInstance> instances = this.discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (int i = 0, size = instances.size(); i < size; i++) {
            ServiceInstance serviceInstance = instances.get(i);
            log.info("CLOUD-PAYMENT-SERVICE 服务的信息有：{}",
                serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() + "\t" + serviceInstance.getPort()
                    + "\t" + serviceInstance.getUri());
        }
        return this.discoveryClient;
    }

    /**
     * 测试自己手写的负载均衡 Rule
     *
     * @return
     */
    @GetMapping(value = "/vat/my/bl")
    public String getMyBalanceInfo() {
        return this.serverPort;
    }
}
