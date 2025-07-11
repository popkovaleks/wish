package com.example.accessing_data_mysql.repository;

import com.example.accessing_data_mysql.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
