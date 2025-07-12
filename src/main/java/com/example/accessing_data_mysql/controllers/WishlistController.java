package com.example.accessing_data_mysql.controllers;

import com.example.accessing_data_mysql.dto.ItemCreateDto;
import com.example.accessing_data_mysql.models.Item;
import com.example.accessing_data_mysql.models.User;
import com.example.accessing_data_mysql.repository.ItemRepository;
import com.example.accessing_data_mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.example.accessing_data_mysql.mappers.ItemMapper.toDto;
import static com.example.accessing_data_mysql.mappers.ItemMapper.toEntity;

@RestController
public class WishlistController {

    @Autowired
    private ItemRepository itemRepository;


    @PostMapping(path = "/items/create")
    public ItemCreateDto createItem(@RequestBody ItemCreateDto itemDto){

        Item savedItem = itemRepository.save(toEntity(itemDto));
        return toDto(savedItem);
    }


}
