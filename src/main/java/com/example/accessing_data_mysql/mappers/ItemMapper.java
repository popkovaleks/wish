package com.example.accessing_data_mysql.mappers;

import com.example.accessing_data_mysql.dto.ItemCreateDto;
import com.example.accessing_data_mysql.dto.ItemDto;
import com.example.accessing_data_mysql.models.Item;
import com.example.accessing_data_mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ItemMapper {

    @Autowired
    private UserRepository userRepository;

    public Item toEntity(ItemCreateDto itemDto){
        Item item = new Item();

        item.setUser(userRepository.findById(itemDto.getUserId()).get());
        item.setLink(itemDto.getLink());
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        return item;
    }

    public  ItemCreateDto toDto(Item item){
        ItemCreateDto itemDto = new ItemCreateDto();

        itemDto.setUserId(item.getUser().getId());
        itemDto.setLink(item.getLink());
        itemDto.setPrice(item.getPrice());
        itemDto.setName(item.getName());
        return itemDto;
    }

    public  ItemDto toResponseDto(Item item){
        ItemDto itemDto = new ItemDto();

        itemDto.setLink(item.getLink());
        itemDto.setPrice(item.getPrice());
        itemDto.setName(item.getName());
        return itemDto;
    }
}
