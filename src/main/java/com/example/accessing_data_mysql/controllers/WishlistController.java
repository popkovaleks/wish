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

@RestController
public class WishlistController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;


    @PostMapping(path = "/items/create")
    public ItemCreateDto createItem(@RequestBody ItemCreateDto itemDto){



//        Optional<User> userOpt = userRepository.findById((item.getUser().getId()));
//        item.setUser(userOpt.get());
        Item savedItem = itemRepository.save(toEntity(itemDto));
        return toDto(savedItem);
    }

    public Item toEntity(ItemCreateDto itemDto){
        Item item = new Item();

        item.setUser(userRepository.findById(itemDto.getUserId()).get());
        item.setLink(itemDto.getLink());
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        return item;
    }

    public ItemCreateDto toDto(Item item){
        ItemCreateDto itemDto = new ItemCreateDto();

        itemDto.setUserId(item.getUser().getId());
        itemDto.setLink(item.getLink());
        itemDto.setPrice(item.getPrice());
        itemDto.setName(item.getName());
        return itemDto;
    }
}
