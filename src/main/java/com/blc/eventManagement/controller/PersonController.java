package com.blc.eventManagement.controller;

import com.blc.eventManagement.dto.PersonDto;
import com.blc.eventManagement.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private PersonService personService;
    public PersonController( PersonService personService){
        this.personService=personService;
    }
    // create person rest api
    @PostMapping()
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto) {
        PersonDto personResponse = personService.createPerson(personDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(personResponse);
    }

    @GetMapping()
    public List<PersonDto> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> updatePerson(@RequestBody PersonDto personDto, @PathVariable(name = "id") long id) {
        PersonDto personResponse = personService.updatePerson(personDto, id);

        return ResponseEntity.status(HttpStatus.OK).body(personResponse);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable(name = "id") Long id) {
        personService.deletePerson(id);
        return ResponseEntity.status(HttpStatus.OK).body("Person deleted successfully");

    }


}