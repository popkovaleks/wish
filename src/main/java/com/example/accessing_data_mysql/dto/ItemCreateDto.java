package com.example.accessing_data_mysql.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCreateDto {

    private Long userId;

    private String name;

    private String link;

    private String price;
}
