package com.matster.taxi.order.system.orderservice.entity.mapper;

import com.matster.taxi.order.system.orderservice.entity.Order;
import com.matster.taxi.order.system.orderservice.model.CreateOrderRequest;
import com.matster.taxi.order.system.orderservice.model.OrderResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    default OrderResponse toDto(Order order) {
        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setOrderId(order.getId());
        orderResponse.setDestination(order.getDestination());
        orderResponse.setStart(order.getStart());

        return orderResponse;
    }


    default Order toEntity(CreateOrderRequest orderReq) {
        Order order = new Order();

        order.setDestination(orderReq.getDestination());
        order.setCustomerId(orderReq.getCustomerId());
        order.setStart(orderReq.getStart());

        return order;
    }
}
