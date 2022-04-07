package com.sparta.restaurant.repository;

import com.sparta.restaurant.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}