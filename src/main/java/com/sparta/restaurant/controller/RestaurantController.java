package com.sparta.restaurant.controller;


import com.sparta.restaurant.dto.RestaurantRequestDto;
import com.sparta.restaurant.model.Restaurant;
import com.sparta.restaurant.repository.RestaurantRepository;
import com.sparta.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final RestaurantRepository restaurantRepository;

//음식점 조회
    @GetMapping("/restaurants")
    public List<Restaurant> showAllDelivery(){
        return restaurantRepository.findAll();
    }

//음식점 등록
    @PostMapping("/restaurant/register")
    public Restaurant createRestaurant(@RequestBody RestaurantRequestDto requestDto) {
      return restaurantService.createRestaurant(requestDto);
    }

}
