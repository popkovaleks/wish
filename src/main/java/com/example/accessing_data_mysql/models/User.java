package com.example.accessing_data_mysql.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    @OneToMany(mappedBy =  "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> items;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Password password;
}
