package com.hw.springcloud.controller;

import com.hw.springcloud.entity.CommonResult;
import com.hw.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 订单控制器
 *
 * @author F1335240
 * @version 1.0
 * @date 2020/11/13 17:24
 **/
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {

    //当单机时，直接填写服务的
//    private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/payment/get/entity/{id}")
    public CommonResult getPayment1(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        log.info("实体类：" + forEntity);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        }
        return new CommonResult<>(400, "无法访问");

    }


}
