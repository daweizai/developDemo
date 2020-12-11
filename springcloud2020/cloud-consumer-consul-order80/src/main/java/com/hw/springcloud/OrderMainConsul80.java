package com.hw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author F1335240
 * @version 1.0
 * @date 2020/12/11 17:40
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMainConsul80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainConsul80.class, args);
    }
}
