package com.example.vegan_life.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ModifyPasswordDto {
    private String password;
    private String newPassword;
}
