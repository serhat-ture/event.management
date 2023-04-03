package com.blc.eventManagement.dto;

import lombok.Data;

import java.util.Set;

@Data
public class CityDto {
    private Long id;
    private String name;
    private String population;
   private Set<EventDto> events;

    }
