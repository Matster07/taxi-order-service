package com.matster.taxi.order.system.orderservice.repository;

import com.matster.taxi.order.system.orderservice.entity.Order;
import com.matster.taxi.order.system.orderservice.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findOrderById(Long id);

    List<Order> findAllByOrderStatus(OrderStatus orderStatus);
}
