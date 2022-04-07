package com.sparta.restaurant.service;

import com.sparta.restaurant.dto.RestaurantRequestDto;
import com.sparta.restaurant.model.Restaurant;
import com.sparta.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    //음식점 등록
    @Transactional
    public Restaurant createRestaurant(RestaurantRequestDto requestDto) {

        String name = requestDto.getName();
        int minOrderPrice = requestDto.getMinOrderPrice();
        int deliveryFee = requestDto.getDeliveryFee();


        if (1000 > minOrderPrice || minOrderPrice > 100000)
            throw new IllegalArgumentException("주문 금액을 맞춰주세요");

        if (minOrderPrice % 100 > 0)
            throw new IllegalArgumentException("100원 단위로 입력해주세요");

        if (0 > deliveryFee || deliveryFee > 10000)
            throw new IllegalArgumentException("배달비를 맞춰주세요");

        if (deliveryFee % 500 > 0)
            throw new IllegalArgumentException("500원 단위로 입력해주세요");

        Restaurant restaurant = new Restaurant(name, minOrderPrice, deliveryFee);
        restaurantRepository.save(restaurant);

       return restaurant;
    }


}