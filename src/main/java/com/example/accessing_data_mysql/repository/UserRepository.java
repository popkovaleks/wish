package com.example.accessing_data_mysql.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.accessing_data_mysql.models.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String name);
}
