package com.example.order_service.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payment {

    public int paymentId;
    public String paymentStatus;
    public String transactionId;
    public int orderId;
    public double amount;
}
