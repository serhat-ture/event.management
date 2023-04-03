package com.blc.eventManagement.service;

import com.blc.eventManagement.dto.CityDto;
import com.blc.eventManagement.mapper.CityMapper;
import com.blc.eventManagement.model.City;
import com.blc.eventManagement.repository.CityRepository;

import com.blc.eventManagement.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CityMapper cityMapper;


    public CityDto createCity(CityDto cityDto) {
        // Our REST API needs to return CityDto to the client hence we convert the saved City JPA entity object into CityDto.
        // We need a City JPA entity to save the city object into the database hence we convert CityDto to a com.javahack.blog.entity.City JPA entity.

        // convert DTO to entity
        City city = cityMapper.mapToEntity(cityDto);
        City newCity = cityRepository.save(city);

        // convert entity to DTO
        CityDto cityResponse = cityMapper.mapToDTO(newCity);
        return cityResponse;
    }


    public List<CityDto> getAllCitys() {
        return cityRepository.findAll().stream()
                .map(city -> cityMapper.mapToDTO(city))
                .collect(Collectors.toList());

    }


    public CityDto getCityById(Long id) {
        City city = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City","id",id));
        return cityMapper.mapToDTO(city);
    }

    //  by default all the methods of JpaRepository are Transactional

    public CityDto updateCity(CityDto cityDto, long id) {
        // get city by id from the database
        City city = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City","id",id));
        city.setPopulation(cityDto.getPopulation());
        city.setName(cityDto.getName());

            City updatedCity = cityRepository.save(city);
        return cityMapper.mapToDTO(updatedCity); //convert to dto for controller
    }


    public void deleteCity(long id) {
        City city = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City","id",id));
        cityRepository.delete(city);

    }
}
