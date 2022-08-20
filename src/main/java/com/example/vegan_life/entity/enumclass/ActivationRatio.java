package com.example.vegan_life.entity.enumclass;

public enum ActivationRatio {
    MUCH("많음(주5회)"),
    REGULAR("보통(주3회)"),
    LESS("적음(주1~2회)");

    private final String kor;

    ActivationRatio(String kor) {
        this.kor = kor;
    }

    public String getKor(){
        return kor;
    }
}
