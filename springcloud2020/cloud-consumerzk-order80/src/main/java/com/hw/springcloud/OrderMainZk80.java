package com.hw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author F1335240
 * @version 1.0
 * @date 2020/12/10 15:16
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMainZk80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainZk80.class, args);
    }
}
