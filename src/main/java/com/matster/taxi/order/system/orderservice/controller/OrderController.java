package com.matster.taxi.order.system.orderservice.controller;

import com.matster.taxi.order.system.orderservice.model.CreateOrderRequest;
import com.matster.taxi.order.system.orderservice.model.CreateOrderResponse;
import com.matster.taxi.order.system.orderservice.model.enums.OrderStatus;
import com.matster.taxi.order.system.orderservice.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Описание API для управления заказами")
@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    @ApiOperation("Получение свободный заказов")
    public ResponseEntity<List<CreateOrderResponse>> getAllUnassignedOrders() {
        return ResponseEntity.ok(orderService.findAllByOrderStatus(OrderStatus.UNASSIGNED));
    }

    @PostMapping
    @ApiOperation("Создание заказа")
    public ResponseEntity<CreateOrderResponse> processOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        return ResponseEntity.ok().body(orderService.createOrder(createOrderRequest));
    }
}
