package com.example.accessing_data_mysql.controllers;

import com.example.accessing_data_mysql.dto.ItemCreateDto;
import com.example.accessing_data_mysql.dto.ItemDto;
import com.example.accessing_data_mysql.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
public class WishlistController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/items/create")
    public ItemCreateDto createItem(@RequestBody ItemCreateDto itemDto){
        return itemService.create(itemDto);
    }

    @GetMapping(path = "/items/{userId}")
    public List<ItemDto> getItemsByUserId(@PathVariable Long userId){

        return itemService.getItems(userId);
    }
}
