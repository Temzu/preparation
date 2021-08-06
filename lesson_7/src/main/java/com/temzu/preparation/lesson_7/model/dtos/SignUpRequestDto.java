package com.temzu.preparation.lesson_7.model.dtos;

import lombok.Data;

@Data
public class SignUpRequestDto {
    private String login;
    private String password;
}
