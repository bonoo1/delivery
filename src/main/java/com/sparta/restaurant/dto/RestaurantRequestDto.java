package com.sparta.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequestDto {

    private String name;

    private int minOrderPrice;

    private int deliveryFee;

    }
