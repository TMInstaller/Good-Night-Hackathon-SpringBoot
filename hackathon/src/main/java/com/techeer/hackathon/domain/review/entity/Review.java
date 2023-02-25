package com.techeer.hackathon.domain.review.entity;


import com.techeer.hackathon.domain.restaurant.entity.Restaurant;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@DynamicInsert
@Table(name = "REVIEW")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 식별자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
    // 리뷰 목록 조회 - 레스토랑 명을 반환합니다
    // 리뷰 조회 - 하나의 레스토랑명을 반환합니다

    @Column(length = 30, nullable = false)
    private String reviewName;
    // 리뷰 목록 조회 - 리뷰 제목으로 검색할 수 있습니다
    // 리뷰 조회 - 리뷰 제목을 반환합니다
    // 리뷰 작성 - 리뷰에는 제목이 있습니다

    @Column(length = 3000, nullable = false)
    private String reviewContent;
    // 리뷰 목록 조회 - 리뷰 내용으로 검색할 수 있습니다
    // 리뷰 조회 - 리뷰 내용을 반환합니다
    // 리뷰 작성 - 리뷰에는 내용이 있습니다

    @CreatedDate
    private LocalDateTime createdDate;

    @Builder
    public Review(
            Restaurant restaurant,
            String reviewName,
            String reviewContent
    ){
        this.restaurant = restaurant;
        this.reviewName = reviewName;
        this.reviewContent = reviewContent;
    }

}
