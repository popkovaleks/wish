package com.example.accessing_data_mysql.repository;

import com.example.accessing_data_mysql.models.Password;
import org.springframework.data.repository.CrudRepository;

public interface PasswordRepository extends CrudRepository<Password, Long> {
}
