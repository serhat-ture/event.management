package com.blc.eventManagement.dto;

import lombok.Data;

import java.util.Set;

@Data
public class PersonDto {
    private Long id;
    private String name;
    private String email;
   private Set<EventDto> events;

    }
