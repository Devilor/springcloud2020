package com.vat.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 东街浊酒づ
 * @date 2020/6/28
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 使用类而不是 xml 的方式向 Spring 容器中注入 RestTemplate 对象
     * 等同于：
     * applicationContext.xml == > <bean id = "" ....><bean/>
     *
     * @return
     */
    @Bean
    //@LoadBalanced
    /**
     *使用自己定制的负载平衡规则，必须去掉 @Balance 注解，否则程序会默认访问 Ribbon 的 RibbonLoadBalancerClient 方法
     */ public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
