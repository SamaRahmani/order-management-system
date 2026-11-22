
package com.oms.inventory.consumer;

import com.oms.inventory.event.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(
            topics = "order-created",
            groupId = "inventory-group"
    )
    public void consumeOrder(OrderEvent orderEvent) {

        System.out.println("========== INVENTORY SERVICE ==========");

        System.out.println("Received order event!");
        System.out.println("Order ID: " + orderEvent.orderId());
        System.out.println("Product: " + orderEvent.productName());
        System.out.println("Quantity: " + orderEvent.quantity());
        System.out.println("Amount: " + orderEvent.amount());

        System.out.println("=======================================");
    }
}
