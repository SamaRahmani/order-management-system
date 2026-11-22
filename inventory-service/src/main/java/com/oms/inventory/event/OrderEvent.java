
package com.oms.inventory.event;

public record OrderEvent(
        String orderId,
        String productName,
        int quantity,
        double amount
) {
}
