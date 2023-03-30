package com.blc.eventManagement.service;

import com.blc.eventManagement.dto.EventDto;
import com.blc.eventManagement.mapper.EventMapper;
import com.blc.eventManagement.model.Event;
import com.blc.eventManagement.model.User;
import com.blc.eventManagement.repository.EventRepository;
import com.blc.eventManagement.repository.UserRepository;
import com.blc.eventManagement.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventMapper eventMapper;



    public EventDto createEvent(long userId, EventDto eventDto) {

        Event event = eventMapper.mapToEntity(eventDto);
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","id",userId));
        //we are maintaining userId in events table
        event.setUser(user);
        // event entity to DB
        Event newEvent = eventRepository.save(event);
        return eventMapper.mapToDTO(newEvent);
    }


   public List<EventDto> getEventsByUserId(long userId) {
        //we need list of event entities
        List<Event> events = eventRepository.findByUserId(userId);
        // convert list of event entities to list of event dto's
        return events.stream().map(event -> eventMapper.mapToDTO(event)).collect(Collectors.toList());
    }


    public EventDto getEventById(Long userId, Long eventId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","id",userId));
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event", "id",eventId));
        return eventMapper.mapToDTO(event);
    }


    public void deleteEvent(Long userId, Long eventId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","id",userId));
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event", "id",eventId));
        eventRepository.delete(event);
    }

    //  by default all the methods of JpaRepository are Transactional

    public EventDto updateEvent(Long userId, long eventId, EventDto eventRequest) {
        //first we get to userId
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","id",userId));
        Event event = eventRepository.findById(eventId).orElseThrow(() ->
                new ResourceNotFoundException("Event", "id",eventId));
        //set to update event entity
        event.setEventName(eventRequest.getEventName());
        event.setParticipants(eventRequest.getParticipants());
        event.setQuota(eventRequest.getQuota());
        event.setStart(eventRequest.getStart());
        event.setFinish(eventRequest.getFinish());

        Event updatedEvent = eventRepository.save(event);
        return eventMapper.mapToDTO(updatedEvent);
    }

}

