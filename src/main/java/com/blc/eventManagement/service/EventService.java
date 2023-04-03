package com.blc.eventManagement.service;

import com.blc.eventManagement.dto.EventDto;
import com.blc.eventManagement.mapper.EventMapper;
import com.blc.eventManagement.model.Event;
import com.blc.eventManagement.model.City;
import com.blc.eventManagement.repository.EventRepository;
import com.blc.eventManagement.repository.CityRepository;
import com.blc.eventManagement.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private EventMapper eventMapper;



    public EventDto createEvent(long cityId, EventDto eventDto) {

        Event event = eventMapper.mapToEntity(eventDto);
        City city = cityRepository.findById(cityId).orElseThrow(() -> new ResourceNotFoundException("City","id",cityId));
        //we are maintaining cityId in events table
        event.setCity(city);
        // event entity to DB
        Event newEvent = eventRepository.save(event);
        return eventMapper.mapToDTO(newEvent);
    }


   public List<EventDto> getEventsByCityId(long cityId) {
        //we need list of event entities
        List<Event> events = eventRepository.findByCityId(cityId);
        // convert list of event entities to list of event dto's
        return events.stream().map(event -> eventMapper.mapToDTO(event)).collect(Collectors.toList());
    }


    public EventDto getEventById(Long cityId, Long eventId) {
        City city = cityRepository.findById(cityId).orElseThrow(() -> new ResourceNotFoundException("City","id",cityId));
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event", "id",eventId));
        return eventMapper.mapToDTO(event);
    }


    public void deleteEvent(Long cityId, Long eventId) {
        City city = cityRepository.findById(cityId).orElseThrow(() -> new ResourceNotFoundException("City","id",cityId));
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event", "id",eventId));
        eventRepository.delete(event);
    }

    //  by default all the methods of JpaRepository are Transactional

    public EventDto updateEvent(Long cityId, long eventId, EventDto eventRequest) {
        //first we get to cityId
        City city = cityRepository.findById(cityId).orElseThrow(
                () -> new ResourceNotFoundException("City","id",cityId));
        Event event = eventRepository.findById(eventId).orElseThrow(
                () -> new ResourceNotFoundException("Event", "id",eventId));
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

