package com.hw.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 付款实体类
 *
 * @author F1335240
 * @version 1.0
 * @date 2020/11/6 17:32
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private String serial;
}
