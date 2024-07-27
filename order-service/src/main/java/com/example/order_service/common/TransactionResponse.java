package com.example.order_service.common;

import com.example.order_service.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponse {
    public Order order;
    public double amount;
    public String transactionId;
    public String message;
}
