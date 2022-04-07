package com.sparta.restaurant.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String restaurantName;

    @Column(nullable = false)
    private int totalPrice;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "orders_id")
    private List<OrderItem> foods;
}

// 상위 엔티티에서 하위 엔티티로 모든 작업을 전파
// Cascadde옵션? OnetoMany 나 ManyToOne에 옵션으로 줄수 있는 값.
// Entity의 상태변화를 전파 시키는 옵션. 만약 Entity의 상태변화기있으면 연관되어있는  OnetoMany 나 ManyToOne
// 에도 상태 변화를 전이 시키는 옵션 . 기본적으록는 아무것도 전이 시키지 않는다.
// 외래키를 매핑할 때 사용. name 속성에 매핑할 외래키 이름 지정.
