package com.example.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order_service.common.TransactionRequest;
import com.example.order_service.common.TransactionResponse;
import com.example.order_service.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest transactionRequest) throws JsonProcessingException {
        return orderService.saveOrder(transactionRequest);
    }
    
    @GetMapping("/getOrder/{orderId}")
    public TransactionResponse getOrder(@PathVariable int orderId) {
        return orderService.getOrder(orderId);
    }
}
