package com.example.vegan_life.security.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// 추후 Redis에 저장할 예정
@Entity
@NoArgsConstructor
@Table(name = "refresh_tokne")
@Getter
public class RefreshToken {
    @Id
    @Column(name = "rt_key")
    private String key; // email

    @Column(name = "rt_value")
    private String value; // Refresh Token

    @Builder
    public RefreshToken(String key, String value){
        this.key=key;
        this.value=value;
    }

    public RefreshToken updateValue(String token){
        this.value = token;
        return this;
    }
}
