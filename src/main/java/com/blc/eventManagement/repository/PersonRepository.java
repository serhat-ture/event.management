package com.blc.eventManagement.repository;

import com.blc.eventManagement.model.Person;
import com.blc.eventManagement.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PersonRepository extends JpaRepository<Person, Long> {
}
