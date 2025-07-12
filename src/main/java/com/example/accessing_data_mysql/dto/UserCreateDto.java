package com.example.accessing_data_mysql.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDto {

    private String name;
    private String email;
    private String password;
    private String repeatPassword;

}
