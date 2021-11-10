package com.matster.taxi.order.system.orderservice.model;

import lombok.Data;

@Data
public class OrderResponse {

    private Integer orderId;
    private String start;
    private String destination;
}
