package com.hw.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现类
 *
 * @author F1335240
 * @version 1.0
 * @date 2021/1/5 14:52
 **/
@Component
@Slf4j
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取并添加
     *
     * @return 访问次数
     */
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            //获取当前的值
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current,next));
        log.info("*****第{}次访问", next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        if (serviceInstances.size()< 1){
            log.warn("当前没有服务实例，请启动服务！");
            return null;
        }
        //获取需要选择的服务实例下标
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
