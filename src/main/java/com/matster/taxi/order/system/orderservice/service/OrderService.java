package com.matster.taxi.order.system.orderservice.service;

import com.matster.taxi.order.system.orderservice.entity.Order;
import com.matster.taxi.order.system.orderservice.entity.mapper.OrderMapper;
import com.matster.taxi.order.system.orderservice.enums.OrderStatus;
import com.matster.taxi.order.system.orderservice.exception.OrderNotFoundException;
import com.matster.taxi.order.system.orderservice.model.CreateOrderRequest;
import com.matster.taxi.order.system.orderservice.model.OrderResponse;
import com.matster.taxi.order.system.orderservice.model.UpdateOrderRequest;
import com.matster.taxi.order.system.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderResponse> findAllByOrderStatus(OrderStatus orderStatus) {
        return orderRepository.findAllByOrderStatus(orderStatus)
                .stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    public OrderResponse createOrder(CreateOrderRequest orderReq) {
        Order order = orderMapper.toEntity(orderReq);

        orderRepository.save(order);

        log.info("{} was successfully created", order);

        return orderMapper.toDto(order);
    }

    public OrderResponse updateOrder(Integer id, UpdateOrderRequest updateOrderReq) {
        Order order = orderRepository
                .findOrderById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order " + id + " wasn't found"));

        if (updateOrderReq.getStatus().equals(OrderStatus.ASSIGNED)) order.setDriverId(updateOrderReq.getDriverId());

        order.setOrderStatus(updateOrderReq.getStatus());

        orderRepository.save(order);

        return orderMapper.toDto(order);
    }


}
