package com.vat.springcloud.mybalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author 东街浊酒づ
 * @date 2020/7/10
 */
public interface IBalance {
    /**
     * @param instanceList
     *
     * @return
     *
     * @Author:东街浊酒づ
     * @Desc: 收集所有服务器中 ServerInstance 的实例
     * @Date:2020/7/10 16:48
     */
    ServiceInstance getService(List<ServiceInstance> instanceList);
}
