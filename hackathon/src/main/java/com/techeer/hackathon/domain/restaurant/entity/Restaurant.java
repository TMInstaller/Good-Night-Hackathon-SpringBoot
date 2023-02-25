package com.techeer.hackathon.domain.restaurant.entity;

import com.techeer.hackathon.domain.review.entity.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@DynamicInsert
@Table(name = "RESTAURANT")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 식별 ID

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @Column(length = 30, nullable = false)
    private String restaurantName;
    // 레스토랑 등록 - 레스토랑에는 레스토랑명이 있습니다
    // 레스토랑 조회 - 레스토랑 명이 반환되어야 합니다

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RestaurantCategory restaurantCategory;
    // 레스토랑 등록 - 레스토랑 카테고리 (한식, 중식, 일식 등)의 내용이 있습니다
    // 레스토랑 수정 - 레스토랑의 카테고리만 변경할 수 있습니다
    // 레스토랑 목록 조회 - 레스토랑 카테고리에 따른 레스토랑 목록을 조회할 수 있습니다
    // 레스토랑 조회 - 레스토랑 명, 카테고리, 음식점의 생성 일자가 반환되어야 합니다

    @CreatedDate
    private LocalDateTime createdDate;
    // 레스토랑 등록 - 등록한 날짜를 기록해야 합니다
    // 레스토랑 조회 - 음식점 생성 일자가 반환 되어야 합니다

    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted;
    // 레스토랑 삭제 - 레스토랑의 삭제로 인하여 작성된 리뷰들이 삭제 되면 안됩니다(Soft Delete)

    @Builder
    public Restaurant(String restaurantName, RestaurantCategory restaurantCategory){
        this.restaurantName = restaurantName;
        this.restaurantCategory = restaurantCategory;
    }
    public void deleteRestaurant(){
        // 레스토랑의 삭제가 이루어진다면 isDeleted 를 True 로 바꾸어 놓고 불러올 때 제외합니다
        this.isDeleted = true;
    }
}
