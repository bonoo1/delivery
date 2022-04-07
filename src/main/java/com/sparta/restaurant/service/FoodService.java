package com.sparta.restaurant.service;

import com.sparta.restaurant.dto.FoodRequestDto;
import com.sparta.restaurant.model.Food;
import com.sparta.restaurant.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

//@ComponentScan(basePackages = {"FoodRequestDto"})
@RequiredArgsConstructor
@Service
public class FoodService {

    private final FoodRepository foodRepository;

    @Transactional
    public void addFood(List<FoodRequestDto> foodRequestDtoList) {

        for (FoodRequestDto foodRequestDto : foodRequestDtoList) {
            String name = foodRequestDto.getName();
            int price = foodRequestDto.getPrice();
            Long restaurantId = foodRequestDto.getId();

//         음식 같은 이름 조회
            for (Food x : this.foodRepository.findAll()) {
                if (x.getRestraurantId().equals(restaurantId) && x.getName().equals(name)) {
                    throw new IllegalArgumentException("같은 이름을 등록할 수 없습니다.");
                }
            }

            if (!(100 <= price && price <= 1000000)) {
                throw new IllegalArgumentException("가격을 맞춰주세요");
            }
            if (price % 100 > 0) {
                throw new IllegalArgumentException("100원 단위로 입력해주세요.");
            }
            Food food = new Food(foodRequestDto);
            foodRepository.save(food);
        }
    }

//    @Transactional
//    public HashMap<FoodRequestDto, Boolean> addFood(List<FoodRequestDto> foodRequestDtoList) {
//        HashMap<FoodRequestDto, Boolean> resultMap = new HashMap<>();
//        for (FoodRequestDto foodRequestDto : foodRequestDtoList) {
//            String name = foodRequestDto.getName();
//            int price = foodRequestDto.getPrice();
//            Long restaurantId = foodRequestDto.getId();
////         음식 같은 이름 조회
//            for (Food x : this.foodRepository.findAll()) {
//                if (x.getRestraurantId().equals(restaurantId) && x.getFoodName().equals(name)) {
//                    resultMap.put(foodRequestDto, false);
//                    throw new IllegalArgumentException("같은 이름을 등록할 수 없습니다.");
//                }
//            }
//            if (!(100 <= price && price <= 1000000)) {
//                resultMap.put(foodRequestDto, false);
//                throw new IllegalArgumentException("가격을 맞춰주세요");
//            }
//            if (price % 100 > 0) {
//                resultMap.put(foodRequestDto, false);
//                throw new IllegalArgumentException("100원 단위로 입력해주세요.");
//            }
//            Food food = new Food(foodRequestDto);
//            foodRepository.save(food);
//            resultMap.put(foodRequestDto, true);
//        }
//        return resultMap
//    }
}

//    @Transactional
//    public void addFood(List <FoodRequestDto> foodRequestDto, Long restaurantId) {
//
//
//
//        for (FoodRequestDto foodDto : foodRequestDto ) {
//
//            Food food = new Food(foodDto,restaurantId);
//            foodRepository.save(food);
//        }
//
//    }


//        ///////////
//
//        // 람다 방식
//        if (this.foodRepository
//                .findAll()
//                .stream()
//                .anyMatch(x -> x.getRestraurantId() == restrauntid && x.getFoodName().equals(name))) {
//            throw new IllegalArgumentException("같은 이름을 등록할 수 없습니다.");
//        }
//        ///////////