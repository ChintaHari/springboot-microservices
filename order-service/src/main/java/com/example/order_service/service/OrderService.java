package com.example.order_service.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.order_service.common.Payment;
import com.example.order_service.common.TransactionRequest;
import com.example.order_service.common.TransactionResponse;
import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@RefreshScope
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;

    private Logger logger = Logger.getLogger(OrderService.class.getName());

    public TransactionResponse saveOrder(TransactionRequest transactionRequest) throws JsonProcessingException {
        String response = "";
        Order order = transactionRequest.getOrder();
        Payment payment = transactionRequest.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        logger.info("Order-Service Request : " + new ObjectMapper().writeValueAsString(transactionRequest));

        Payment paymentResponse = restTemplate
                                        .postForObject(ENDPOINT_URL,
                                        // "http://PAYMENT-SERVICE/payment/doPayment",
                                        // "http://localhost:9191/payment/doPayment",
                                             payment,
                                Payment.class);

        logger.info("Payment-Service Response from Order-Service REST call : " + new ObjectMapper().writeValueAsString(paymentResponse));

        response = paymentResponse.getPaymentStatus().equals("success") ? "payment processing successful and order placed" : "there is a failure in payment api, order added to cart";                                
        orderRepository.save(order);

        return TransactionResponse.builder()
                .order(order)
                .amount(paymentResponse.getAmount())
                .transactionId(paymentResponse.getTransactionId())
                .message(response)
                .build();
    }

    public TransactionResponse getOrder(int orderId) {
        Order order = orderRepository.findById(orderId).get();
        return TransactionResponse.builder()
                .order(order)
                .amount(order.getPrice())
                .transactionId("")
                .message("Order found in Order-Service")
                .build();
    }
    
}
