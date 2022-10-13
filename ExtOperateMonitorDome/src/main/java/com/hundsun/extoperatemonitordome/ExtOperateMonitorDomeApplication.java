package com.hundsun.extoperatemonitordome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hundsun.extoperatemonitordome.datasource.dao")
public class ExtOperateMonitorDomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExtOperateMonitorDomeApplication.class, args);
    }

}
