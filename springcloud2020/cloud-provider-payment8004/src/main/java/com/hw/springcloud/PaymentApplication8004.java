package com.hw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author F1335240
 * @version 1.0
 * @date 2020/11/27 17:43
 **/
@SpringBootApplication
//该注解用于向使用consul或者zookeeper作为注册中心时注册服务
@EnableDiscoveryClient
public class PaymentApplication8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8004.class, args);
    }
}
