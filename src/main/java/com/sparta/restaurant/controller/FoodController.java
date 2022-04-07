package com.sparta.restaurant.controller;

import com.sparta.restaurant.dto.FoodRequestDto;
import com.sparta.restaurant.model.Food;
import com.sparta.restaurant.repository.FoodRepository;
import com.sparta.restaurant.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;
    private final FoodRepository foodRepository;
    //음식 조회
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> findFood(@PathVariable(name = "restaurantId", required = true) long restaurantId) {

        List<Food> foods = new ArrayList<>();

        for (Food food : this.foodRepository.findAll()) {
            if (food.getRestraurantId().equals(restaurantId)) {
                foods.add(food);
            }
        }
        return foods;
        // return foodRepository.findAll().stream().filter(x -> x.getRestraurantId().equals(restaurantId)).collect(Collectors.toList());
    }

    //음식 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void addFood(@PathVariable(name = "restaurantId", required = true) long restaurantId, @RequestBody List<FoodRequestDto> foodDtoList) {
        for (FoodRequestDto foodRequestDto : foodDtoList) {
            foodRequestDto.setId(restaurantId);
        }
        foodService.addFood(foodDtoList);
        //return foodService.addFood(foodDtoList);
    }
}