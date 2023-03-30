package com.blc.eventManagement.repository;

import com.blc.eventManagement.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface EventRepository extends JpaRepository <Event, Long>{
   List<Event> findByUserId(long userId);
}
