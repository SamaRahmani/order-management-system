package com.oms.order.event;

public record OrderEvent(
        String orderId,
        String productName,
        int quantity,
        double amount
) {
}