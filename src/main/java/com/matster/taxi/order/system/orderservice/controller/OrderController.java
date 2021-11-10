package com.matster.taxi.order.system.orderservice.controller;

import com.matster.taxi.order.system.orderservice.model.CreateOrderRequest;
import com.matster.taxi.order.system.orderservice.model.OrderResponse;
import com.matster.taxi.order.system.orderservice.enums.OrderStatus;
import com.matster.taxi.order.system.orderservice.model.UpdateOrderRequest;
import com.matster.taxi.order.system.orderservice.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    public ResponseEntity<List<OrderResponse>> getUnassignedOrders() {
        return ResponseEntity.ok(orderService.findAllByOrderStatus(OrderStatus.CREATED));
    }

    @PostMapping
    @ApiOperation("Создание заказа")
    public ResponseEntity<OrderResponse> processOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        return ResponseEntity.ok(orderService.createOrder(createOrderRequest));
    }

    @PostMapping("/{id}/status")
    @ApiOperation("Обновление статуса заказа")
    public ResponseEntity<OrderResponse> updateOrder(@ApiParam("Идентификатор заказа")
                                                     @PathVariable Integer id,
                                                     @RequestBody UpdateOrderRequest updateOrderReq) {
        return ResponseEntity.ok(orderService.updateOrder(id, updateOrderReq));
    }
}
