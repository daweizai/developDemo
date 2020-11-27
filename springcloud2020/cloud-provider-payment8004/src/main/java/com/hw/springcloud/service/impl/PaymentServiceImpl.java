package com.hw.springcloud.service.impl;

import com.hw.springcloud.dao.PaymentDao;
import com.hw.springcloud.entity.Payment;
import com.hw.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author F1335240
 * @version 1.0
 * @date 2020/11/6 18:07
 **/
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment findById(Long id) {
        return paymentDao.findById(id);
    }
}
