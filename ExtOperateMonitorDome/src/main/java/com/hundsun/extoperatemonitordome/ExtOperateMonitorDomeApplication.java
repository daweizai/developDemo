package com.hundsun.extoperatemonitordome;

import com.hundsun.extoperatemonitordome.util.CustomApplicationRunner;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hundsun.extoperatemonitordome.datasource.dao")
public class ExtOperateMonitorDomeApplication {

    public static void main(String[] args) {
        // 校验数据库是否创建
        CustomApplicationRunner.generateDatabasePath();
        SpringApplication.run(ExtOperateMonitorDomeApplication.class, args);
    }

}
