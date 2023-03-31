package com.blc.eventManagement.service;

import com.blc.eventManagement.dto.PersonDto;
import com.blc.eventManagement.mapper.PersonMapper;
import com.blc.eventManagement.model.Person;
import com.blc.eventManagement.repository.PersonRepository;

import com.blc.eventManagement.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonMapper personMapper;


    public PersonDto createPerson(PersonDto personDto) {
        // Our REST API needs to return PersonDto to the client hence we convert the saved Person JPA entity object into PersonDto.
        // We need a Person JPA entity to save the person object into the database hence we convert PersonDto to a com.javahack.blog.entity.Person JPA entity.

        // convert DTO to entity
        Person person = personMapper.mapToEntity(personDto);
        Person newPerson = personRepository.save(person);

        // convert entity to DTO
        PersonDto personResponse = personMapper.mapToDTO(newPerson);
        return personResponse;
    }


    public List<PersonDto> getAllPersons() {
        return personRepository.findAll().stream()
                .map(person -> personMapper.mapToDTO(person))
                .collect(Collectors.toList());

    }


    public PersonDto getPersonById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person","id",id));
        return personMapper.mapToDTO(person);
    }

    //  by default all the methods of JpaRepository are Transactional

    public PersonDto updatePerson(PersonDto personDto, long id) {
        // get person by id from the database
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person","id",id));
        person.setEmail(personDto.getEmail());
        person.setName(personDto.getName());
        person.setPassword(personDto.getPassword());
            Person updatedPerson = personRepository.save(person);
        return personMapper.mapToDTO(updatedPerson); //convert to dto for controller
    }


    public void deletePerson(long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person","id",id));
        personRepository.delete(person);

    }
}
