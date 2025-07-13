package com.example.accessing_data_mysql.controllers;

import com.example.accessing_data_mysql.dto.UserCreateDto;
import com.example.accessing_data_mysql.repository.PasswordRepository;
import com.example.accessing_data_mysql.repository.UserRepository;
import com.example.accessing_data_mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordRepository passwordRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserCreateDto userDto){
        userService.registerUser(userDto);

        return "User registered";

    }
}
