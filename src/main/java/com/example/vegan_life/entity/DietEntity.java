package com.example.vegan_life.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name="diet")
@Getter
public class DietEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diet_idx;
}
