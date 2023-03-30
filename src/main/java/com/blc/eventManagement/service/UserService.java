package com.blc.eventManagement.service;

import com.blc.eventManagement.dto.UserDto;
import com.blc.eventManagement.mapper.UserMapper;
import com.blc.eventManagement.model.User;
import com.blc.eventManagement.repository.UserRepository;

import com.blc.eventManagement.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;


    public UserDto createUser(UserDto userDto) {
        // Our REST API needs to return UserDto to the client hence we convert the saved User JPA entity object into UserDto.
        // We need a User JPA entity to save the user object into the database hence we convert UserDto to a com.javahack.blog.entity.User JPA entity.

        // convert DTO to entity
        User user = userMapper.mapToEntity(userDto);
        User newUser = userRepository.save(user);

        // convert entity to DTO
        UserDto userResponse = userMapper.mapToDTO(newUser);
        return userResponse;
    }


    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> userMapper.mapToDTO(user))
                .collect(Collectors.toList());

    }


    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id",id));
        return userMapper.mapToDTO(user);
    }

    //  by default all the methods of JpaRepository are Transactional

    public UserDto updateUser(UserDto userDto, long id) {
        // get user by id from the database
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id",id));
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
            User updatedUser = userRepository.save(user);
        return userMapper.mapToDTO(updatedUser); //convert to dto for controller
    }


    public void deleteUser(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id",id));
        userRepository.delete(user);

    }
}
