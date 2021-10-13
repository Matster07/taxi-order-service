package com.matster.taxi.order.system.orderservice.model;

import lombok.Data;

@Data
public class CreateOrderRequest {

    private Long customerId;
    private String start;
    private String destination;
}