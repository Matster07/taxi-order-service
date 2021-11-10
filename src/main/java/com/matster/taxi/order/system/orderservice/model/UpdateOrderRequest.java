package com.matster.taxi.order.system.orderservice.model;

import com.matster.taxi.order.system.orderservice.enums.OrderStatus;
import lombok.Data;

@Data
public class UpdateOrderRequest {

    private Long driverId;
    private OrderStatus status;
}
