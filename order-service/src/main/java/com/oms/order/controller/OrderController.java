
package com.oms.order.controller;

import com.oms.order.event.OrderEvent;
import com.oms.order.producer.OrderProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public ResponseEntity<String> createOrder(
            @RequestBody OrderEvent orderEvent) {

        orderProducer.sendOrderEvent(orderEvent);

        return ResponseEntity.ok(
                "Order event published successfully!"
        );
    }
}
