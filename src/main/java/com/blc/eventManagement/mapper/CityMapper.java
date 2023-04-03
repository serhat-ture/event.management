package com.blc.eventManagement.mapper;

import com.blc.eventManagement.dto.CityDto;
import com.blc.eventManagement.model.City;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {

    @Autowired
    private ModelMapper modelMapper;

    // convert Entity into DTO
    public CityDto mapToDTO(City city) {
        CityDto cityDto = modelMapper.map(city, CityDto.class);
        return cityDto;
    }

    // convert DTO to entity
    public City mapToEntity(CityDto cityDto) {
        City city = modelMapper.map(cityDto, City.class);
        return city;
    }
}