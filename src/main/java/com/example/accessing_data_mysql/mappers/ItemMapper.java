package com.example.accessing_data_mysql.mappers;

import com.example.accessing_data_mysql.dto.ItemCreateDto;
import com.example.accessing_data_mysql.models.Item;
import com.example.accessing_data_mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemMapper {

    @Autowired
    private static UserRepository userRepository;

    public static Item toEntity(ItemCreateDto itemDto){
        Item item = new Item();

        item.setUser(userRepository.findById(itemDto.getUserId()).get());
        item.setLink(itemDto.getLink());
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        return item;
    }

    public static ItemCreateDto toDto(Item item){
        ItemCreateDto itemDto = new ItemCreateDto();

        itemDto.setUserId(item.getUser().getId());
        itemDto.setLink(item.getLink());
        itemDto.setPrice(item.getPrice());
        itemDto.setName(item.getName());
        return itemDto;
    }
}
