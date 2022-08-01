package com.example.vegan_life.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DietDto {
    private Long member_id;

    private Long diet_id;
    private Date intake_time;
    private String diet_name_kor;
    private String diet_name_eng;
    private Float calorie;
    private Float carbohydrate;
    private Float protein;
    private Float fat;
    private Float calcium;
    private Float vitamin;
    private Float iron;
    // 이미지
}
