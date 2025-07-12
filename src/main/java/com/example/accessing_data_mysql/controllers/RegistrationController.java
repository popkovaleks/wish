package com.example.accessing_data_mysql.controllers;

import com.example.accessing_data_mysql.dto.UserCreateDto;
import com.example.accessing_data_mysql.models.Password;
import com.example.accessing_data_mysql.models.User;
import com.example.accessing_data_mysql.repository.PasswordRepository;
import com.example.accessing_data_mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.accessing_data_mysql.mappers.UserMapper.registrationToEntity;
import static com.example.accessing_data_mysql.service.PasswordHasher.generateSalt;
import static com.example.accessing_data_mysql.service.PasswordHasher.hashPassword;

@RestController
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordRepository passwordRepository;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserCreateDto userDto){
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()){
            throw new RuntimeException("User already exists");
        }

        if (!(userDto.getPassword().equals(userDto.getRepeatPassword()))){
            throw new RuntimeException("Passwords are not equal");
        }

        String generatedSalt =  generateSalt();
        String hashedPassword = hashPassword(userDto.getPassword(), generatedSalt);
        User user = registrationToEntity(userDto);

        userRepository.save(user);
        Password password = new Password();

        password.setUser(user);
        password.setSalt(generatedSalt);
        password.setPasswordHash(hashedPassword);
        passwordRepository.save(password);


        return "User registered";

    }
}
