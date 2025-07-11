package com.example.accessing_data_mysql.controllers;

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
    public Item createItem(@RequestBody Item item){

//        Optional<User> userOpt = userRepository.findById((item.getUser().getId()));
//        item.setUser(userOpt.get());
        itemRepository.save(item);
        return item;
    }
}
