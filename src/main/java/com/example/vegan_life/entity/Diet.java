package com.example.vegan_life.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="diet")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Diet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="diet_id")
    private Long diet_id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="life_check_id")
    private LifeCheck lifeCheck;

    private String nameKor;
    private Integer calorie;
    private Integer carbohydrate;
    private Integer protein;
    private Integer fat;

}
