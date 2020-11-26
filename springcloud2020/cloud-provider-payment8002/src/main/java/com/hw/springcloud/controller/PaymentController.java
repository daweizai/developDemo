package com.hw.springcloud.controller;

import com.hw.springcloud.entity.CommonResult;
import com.hw.springcloud.entity.Payment;
import com.hw.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author F1335240
 * @version 1.0
 * @date 2020/11/6 18:09
 **/
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    @ResponseBody
    public CommonResult<Object> save(@RequestBody Payment payment) {
        if (null == payment) {
            return new CommonResult<>(405, "参数不能为空", null);
        }
        int i = 0;
        try {
            i = paymentService.create(payment);
        } catch (Exception e) {
            return new CommonResult<>(405, e.getMessage(), null);
        }
        if (i > 0) {
            return new CommonResult<>(200, "添加成功,端口： "+serverPort, null);
        } else {
            return new CommonResult<>(405, "添加失败,端口： "+serverPort, null);
        }
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public CommonResult<Object> findById(@PathVariable(value = "id") Long id) {
        if (null == id) {
            return new CommonResult<>(405, "参数不能为空", null);
        }
        Payment payment = null;
        try {
            payment = paymentService.findById(id);
        } catch (Exception e) {
            return new CommonResult<>(405, e.getMessage()+",端口： "+serverPort, null);
        }
        return new CommonResult<>(200, "查询成功,端口： "+serverPort, payment);
    }
}
