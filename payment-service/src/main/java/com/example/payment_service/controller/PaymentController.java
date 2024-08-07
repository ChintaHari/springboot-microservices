package com.example.payment_service.controller;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment_service.entity.Payment;
import com.example.payment_service.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    private Logger logger = Logger.getLogger(PaymentService.class.getName());


    @PostMapping("/doPayment")
    public Payment doPayment(@RequestBody Payment payment) throws JsonProcessingException {
        System.out.println("Inside doPayment of PaymentController");
        return paymentService.doPayment(payment);
    }

    @GetMapping("/getPaymentByOrderId/{orderId}")
    public Optional<Payment> getPaymentByOrderId(@PathVariable int orderId) {
        Payment payment = paymentService.getPaymentByOrderId(orderId).get();
        logger.info("Payment-Serivce getPaymentByOrderId : " + payment);
        return paymentService.getPaymentByOrderId(orderId);
    }
    
}
