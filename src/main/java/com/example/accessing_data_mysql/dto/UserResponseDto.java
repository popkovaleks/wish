package com.example.accessing_data_mysql.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;
}
