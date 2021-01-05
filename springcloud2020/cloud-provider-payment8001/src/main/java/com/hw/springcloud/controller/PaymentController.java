package com.hw.springcloud.controller;

import com.hw.springcloud.entity.CommonResult;
import com.hw.springcloud.entity.Payment;
import com.hw.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private DiscoveryClient discoveryClient;

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
            return new CommonResult<>(200, "添加成功,端口： " + serverPort, null);
        } else {
            return new CommonResult<>(405, "添加失败,端口： " + serverPort, null);
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
            return new CommonResult<>(405, e.getMessage() + ",端口： " + serverPort, null);
        }
        return new CommonResult<>(200, "查询成功,端口： " + serverPort, payment);
    }


    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("********element: " + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
