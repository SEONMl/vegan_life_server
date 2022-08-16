package com.example.vegan_life.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diet_id;

    private String name_kor;
    private String name_eng;
    private Float calorie;
    private Float carbohydrate;
    private Float protein;
    private Float fat;
    private Float calcium;
    private Float vitamin;
    private Float iron;
}