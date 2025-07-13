package com.example.accessing_data_mysql.service;

import com.example.accessing_data_mysql.dto.ItemCreateDto;
import com.example.accessing_data_mysql.dto.ItemDto;
import com.example.accessing_data_mysql.mappers.ItemMapper;
import com.example.accessing_data_mysql.models.Item;
import com.example.accessing_data_mysql.models.User;
import com.example.accessing_data_mysql.repository.ItemRepository;
import com.example.accessing_data_mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemMapper itemMapper;

    public ItemCreateDto create(ItemCreateDto itemCreateDto){
        Item item = itemMapper.toEntity(itemCreateDto);
        item.setUser(userRepository.findById(itemCreateDto.getUserId()).get());

        Item savedItem = itemRepository.save(item);
        return itemMapper.toDto(savedItem);
    }

    public List<ItemDto> getItems(Long userId){
        Optional<User> userOpt = userRepository.findById(userId);
        if(!userOpt.isPresent()){
            throw new RuntimeException("User not found");
        }

//        List<Item> items = itemRepository.findByUserId(userId);
        List<Item> items = userOpt.get().getItems();
        List<ItemDto> itemsDto = new ArrayList<>();

        for(Item item : items){
            itemsDto.add(itemMapper.toResponseDto(item));
        }

        return itemsDto;
    }
}
