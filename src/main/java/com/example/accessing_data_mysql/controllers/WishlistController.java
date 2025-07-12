package com.example.accessing_data_mysql.controllers;

import com.example.accessing_data_mysql.dto.ItemCreateDto;
import com.example.accessing_data_mysql.dto.ItemDto;
import com.example.accessing_data_mysql.mappers.ItemMapper;
import com.example.accessing_data_mysql.models.Item;
import com.example.accessing_data_mysql.models.User;
import com.example.accessing_data_mysql.repository.ItemRepository;
import com.example.accessing_data_mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.accessing_data_mysql.mappers.ItemMapper.*;



@RestController
public class WishlistController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemMapper itemMapper;


    @PostMapping(path = "/items/create")
    public ItemCreateDto createItem(@RequestBody ItemCreateDto itemDto){
        Item item = itemMapper.toEntity(itemDto);
        Item savedItem = itemRepository.save(item);
        return itemMapper.toDto(savedItem);
    }

    @GetMapping(path = "/items/{userId}")
    public List<ItemDto> getItemsByUserId(@PathVariable Long userId){

        Optional<User> userOpt = userRepository.findById(userId);
        if(!userOpt.isPresent()){
            throw new RuntimeException("User not found");
        }

        List<Item> items = itemRepository.findByUserId(userId);
        List<ItemDto> itemsDto = new ArrayList<>();

        for(Item item : items){
           itemsDto.add(itemMapper.toResponseDto(item));
        }

        return itemsDto;
    }


}
