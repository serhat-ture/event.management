package com.blc.eventManagement.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Set<EventDto> events;

    }
