package com.sparta.restaurant.dto;

import com.sparta.restaurant.model.OrderItem;
import lombok.Getter;

import java.util.List;

@Getter
public class OrdersRequestDto {

    private Long restaurantId;
    private List<OrderItem> foods;

}