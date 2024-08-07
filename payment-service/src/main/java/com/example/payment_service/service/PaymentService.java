package com.example.payment_service.service;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payment_service.entity.Payment;
import com.example.payment_service.repository.PaymentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PaymentService {
    
    @Autowired
    private PaymentRepository paymentRepository;

    private Logger logger = Logger.getLogger(PaymentService.class.getName());


    public Payment doPayment(Payment payment) throws JsonProcessingException {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());

        logger.info("Payment-Serivce request : " + new ObjectMapper().writeValueAsString(payment));
        return paymentRepository.save(payment);
    }

    public String paymentProcessing() {
        // api should be 3rd party payment gateway (paypal, paytm etc)
        return new Random().nextBoolean() ? "success" : "false";
    }

    public Optional<Payment> getPaymentByOrderId(int orderId) {
        return paymentRepository.findByOrderId(orderId);
    }
}
