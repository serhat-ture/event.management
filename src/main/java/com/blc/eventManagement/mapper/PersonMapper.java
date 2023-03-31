package com.blc.eventManagement.mapper;

import com.blc.eventManagement.dto.PersonDto;
import com.blc.eventManagement.model.Person;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    @Autowired
    private ModelMapper modelMapper;

    // convert Entity into DTO
    public PersonDto mapToDTO(Person person) {
        PersonDto personDto = modelMapper.map(person, PersonDto.class);
        return personDto;
    }

    // convert DTO to entity
    public Person mapToEntity(PersonDto personDto) {
        Person person = modelMapper.map(personDto, Person.class);
        return person;
    }
}