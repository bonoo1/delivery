package com.sparta.restaurant.repository;

import com.sparta.restaurant.model.OrderItem;
import com.sparta.restaurant.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
    List<OrderItem> findOrderItemsByOrders(Orders orders);
}