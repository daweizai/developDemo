package com.hw.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一的消息返回类
 *
 * @author F1335240
 * @version 1.0
 * @date 2020/11/6 17:47
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private int code;
    private String message;
    private T data;

    public CommonResult(int code, T data) {
        this.code = code;
        this.data = data;
    }
}
