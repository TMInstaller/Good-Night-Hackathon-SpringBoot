package com.techeer.hackathon.domain.restaurant.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RestaurantCategory {
    KOREAN_RESTAURANT("한식"),
    CHINESE_RESTAURANT("중식"),
    ITALIAN_RESTAURANT("이태리식");

    private final String restaurantCategory;

}
