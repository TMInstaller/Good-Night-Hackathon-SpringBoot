package com.techeer.hackathon.review.entity;


import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "REVIEW")
public class Review {
    @Id
    private Long id;

    // 레스토랑 명, 등록 시간, 리뷰 제목, 리뷰 내용
    @Column(length = 30, nullable = false)
    private String reviewRestaurantName;

    @Column(length = 30, nullable = false)
    private String reviewName;

    @Column(length = 3000, nullable = false)
    private String reviewContent;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private java.util.Date reviewRegistDate;
}
