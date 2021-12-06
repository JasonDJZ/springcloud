package com.dengjz.springcloud.service;

import com.dengjz.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Admin
 * @date 2021/12/2
 **/
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
