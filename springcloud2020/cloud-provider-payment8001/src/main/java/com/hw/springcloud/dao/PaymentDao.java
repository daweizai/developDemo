package com.hw.springcloud.dao;

import com.hw.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author F1335240
 * @version 1.0
 * @date 2020/11/6 17:43
 **/
@Mapper
public interface PaymentDao {

    /**
     * 添加接口
     */
    int create(Payment payment);

    /**
     * 通过id查询
     */
    Payment findById(@Param("id") Long id);


}
