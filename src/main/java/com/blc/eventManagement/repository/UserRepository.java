package com.blc.eventManagement.repository;

import com.blc.eventManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
}
