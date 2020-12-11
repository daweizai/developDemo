package com.hw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 整合Consul注册服务架构
 *
 * @author F1335240
 * @version 1.0
 * @date 2020/12/11 15:54
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8006.class, args);
    }
}
