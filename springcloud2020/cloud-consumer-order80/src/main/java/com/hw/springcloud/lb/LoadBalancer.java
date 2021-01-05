package com.hw.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义负载均衡接口
 * @author F1335240
 */
public interface LoadBalancer {
    /**
     * 获取服务实例
     * @param serviceInstances  服务实例集合
     * @return 服务实例
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
