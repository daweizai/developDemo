package com.hw.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author F1335240
 * @version 1.0
 * @date 2020/11/13 17:28
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced   //开启微服务的负载均衡，否则会报错
    public RestTemplate getRestTemplate() {
        return new RestTemplate();

    }
}
