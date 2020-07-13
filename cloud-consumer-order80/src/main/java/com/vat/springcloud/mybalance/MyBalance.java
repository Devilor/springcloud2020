package com.vat.springcloud.mybalance;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 东街浊酒づ
 * @date 2020/7/10
 */
@Component
public class MyBalance implements IBalance {

    /**
     * 原子操作 Integer
     */
    private AtomicInteger atomicInteger = new AtomicInteger();

    /**
     * @param
     *
     * @return
     *
     * @Author:东街浊酒づ
     * @Desc:轮询规则
     * @Date:2020/7/10 16:48
     */
    private final int getAndIncrementIndex() {
        int current;
        int next;

        //自旋锁，自定义轮询的选取规则
        for (; ; ) {
            current = this.atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;
            System.out.println("这是第 " + next + " 次轮询....");
            if (this.atomicInteger.compareAndSet(current, next)) {
                return next;
            }
        }

    }

    /**
     * @param instanceList
     *
     * @return
     *
     * @Author:东街浊酒づ
     * @Desc: 自己手写轮询算法获取 Service 服务
     * @Date:2020/7/10 16:48
     */
    @Override
    public ServiceInstance getService(List<ServiceInstance> instanceList) {
        int index = this.getAndIncrementIndex() % instanceList.size();
        return instanceList.get(index);
    }
}
