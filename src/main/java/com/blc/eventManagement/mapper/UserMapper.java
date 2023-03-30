package com.blc.eventManagement.mapper;

import com.blc.eventManagement.dto.UserDto;
import com.blc.eventManagement.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    // convert Entity into DTO
    public UserDto mapToDTO(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    // convert DTO to entity
    public User mapToEntity(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return user;
    }
}