package com.example.accessing_data_mysql.controllers;


import com.example.accessing_data_mysql.dto.UserResponseDto;
import com.example.accessing_data_mysql.models.User;
import com.example.accessing_data_mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/demo")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {

        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        userRepository.save(newUser);

        return "Saved";

    }

    @GetMapping(path="/all")
    public @ResponseBody List<UserResponseDto> getAllUsers() {
        Iterable<User> users = userRepository.findAll();
        List<UserResponseDto> userDtos = new ArrayList<>();
        for(User user : users){
            UserResponseDto userDto = toDto(user);
            userDtos.add(userDto);

        }
        return userDtos;
    }

    public static UserResponseDto toDto(User user){
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
