package com.dengjz.springcloud.controller;

import com.dengjz.springcloud.entities.CommonResult;
import com.dengjz.springcloud.entities.Payment;
import com.dengjz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Admin
 * @date 2021/12/2
 **/
@Slf4j
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("*************插入结果："+result);
        if (result>0){
            return new CommonResult(200,"插入成功",result);
        }else {
            return new CommonResult(444,"插入失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment= paymentService.getPaymentById(id);
        log.info("*************查询结果："+payment);
        if (payment != null){
            return new CommonResult(200,"查询成功",payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询ID："+id,null);
        }
    }
}
