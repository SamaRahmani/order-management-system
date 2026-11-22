
package com.oms.order.producer;

import com.oms.order.event.OrderEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendOrderEvent(OrderEvent orderEvent) {

        kafkaTemplate.send(
                "order-created",
                orderEvent.orderId(),
                orderEvent
        ).whenComplete((result, exception) -> {

            if (exception == null) {

                System.out.println(
                        "Order event successfully published to Kafka!"
                );

                System.out.println(
                        "Topic: " + result.getRecordMetadata().topic()
                );

                System.out.println(
                        "Partition: " + result.getRecordMetadata().partition()
                );

                System.out.println(
                        "Offset: " + result.getRecordMetadata().offset()
                );

            } else {

                System.err.println(
                        "Failed to publish order event: " + exception.getMessage()
                );
            }
        });
    }

}
