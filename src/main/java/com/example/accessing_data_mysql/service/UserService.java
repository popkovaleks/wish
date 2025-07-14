package com.example.accessing_data_mysql.service;

import com.example.accessing_data_mysql.dto.UserCreateDto;
import com.example.accessing_data_mysql.models.Password;
import com.example.accessing_data_mysql.models.User;
import com.example.accessing_data_mysql.repository.PasswordRepository;
import com.example.accessing_data_mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.accessing_data_mysql.mappers.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.accessing_data_mysql.service.PasswordHasher.generateSalt;
import static com.example.accessing_data_mysql.service.PasswordHasher.hashPassword;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordRepository passwordRepository;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void registerUser(UserCreateDto userDto){
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()){
            throw new RuntimeException("User already exists");
        }

        if (!(userDto.getPassword().equals(userDto.getRepeatPassword()))){
            throw new RuntimeException("Passwords are not equal");
        }

        try {
            String generatedSalt =  generateSalt();
            String hashedPassword = hashPassword(userDto.getPassword(), generatedSalt);
            User user = userMapper.registrationToEntity(userDto);

            userRepository.save(user);
            Password password = new Password();

            password.setUser(user);
            password.setSalt(generatedSalt);
            password.setPasswordHash(hashedPassword);
            passwordRepository.save(password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
