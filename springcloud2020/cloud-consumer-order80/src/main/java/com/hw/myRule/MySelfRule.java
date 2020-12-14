package com.hw.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义Ribbon类，更换其策略
 * Ribbon更换策略时不能被原启动器扫描到，否则会失效
 * @author F1335240
 * @version 1.0
 * @date 2020/12/14 16:44
 **/
@Configuration
public class MySelfRule {


    @Bean
    public IRule myRule(){
        return new RandomRule();//定义为随机策略
    }

}
