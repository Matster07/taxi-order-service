package com.matster.taxi.order.system.orderservice.model;

import lombok.Data;

@Data
public class CreateOrderResponse {

    private Long id;
    private String destination;
    private String start;
}
