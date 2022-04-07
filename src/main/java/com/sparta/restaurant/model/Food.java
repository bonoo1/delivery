package com.sparta.restaurant.model;

import com.sparta.restaurant.dto.FoodRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Food {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private Long restraurantId;


    public Food(String foodName, int foodPrice, Long restraurantId) {
        this.name = foodName;
        this.price = foodPrice;
        this.restraurantId = restraurantId;
    }

    public Food(FoodRequestDto foodRequestDto, Long restraurantId) {

        this.name = foodRequestDto.getName();
        this.price = foodRequestDto.getPrice();
        this.restraurantId = restraurantId;
    }

    public Food(FoodRequestDto foodrequestDto) {
        this.name = foodrequestDto.getName();
        this.price = foodrequestDto.getPrice();
        this.restraurantId = foodrequestDto.getId();
    }


}
//
//model -> dto -> controller -> service
