package com.vat.springcloud.cotroller;

import com.vat.springcloud.entities.CommonResult;
import com.vat.springcloud.entities.Payment;
import com.vat.springcloud.mybalance.MyBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author 东街浊酒づ
 * @date 2020/6/28
 */
@RestController
@Slf4j
public class OrderController {
    //public static final String PAYMENT_URL = "http://localhost:8001";           单机版本
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";    //集群版本

    @Resource
    private RestTemplate restTemplate;

    /**
     * 引入自己的负载均衡规则
     */
    @Resource
    private MyBalance myBalance;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping(value = "/vat/payment/mb")
    public String getInfoByMyBalance() {
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (serviceInstanceList == null || serviceInstanceList.size() <= 0) {
            return null;
        }
        ServiceInstance serviceInstance = myBalance.getService(serviceInstanceList);
        URI uri = serviceInstance.getUri();
        System.out.println("URL：" + uri + "/vat/my/bl");
        //Ribbon 是默认的方式通过调用服务名来达到负载规则实现的和自己自定义的轮询规则相比，而自己的是通过获取到服务名下的所有服务器然后轮询服务器主机的方式实现的
        return restTemplate.getForObject(uri + "/vat/my/bl", String.class);
    }
}
