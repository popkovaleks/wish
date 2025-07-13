package com.example.accessing_data_mysql.mappers;

import com.example.accessing_data_mysql.dto.UserCreateDto;
import com.example.accessing_data_mysql.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User registrationToEntity(UserCreateDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return user;

    }
}
