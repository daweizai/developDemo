package com.hw.springcloud.service;

import com.hw.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;


/**
 * 支付业务层
 *
 * @author F1335240
 */
public interface PaymentService {
    /**
     * 添加接口
     */
    int create(Payment payment);

    /**
     * 通过id查询
     */
    Payment findById(@Param("id") Long id);

}
