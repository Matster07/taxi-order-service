package com.matster.taxi.order.system.orderservice.entity;

import com.matster.taxi.order.system.orderservice.model.enums.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus = OrderStatus.UNASSIGNED;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "driver_id")
    private Long driverId;

    @Column(name = "start")
    private String start;

    @Column(name = "destination")
    private String destination;
}
