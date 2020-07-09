package com.vat.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author 东街浊酒づ
 * @date 2020/7/9
 */
@SpringBootConfiguration
public class MyselfRule {
    @Bean
    public IRule getMyselfRule() {
        return new RandomRule();
    }
}
