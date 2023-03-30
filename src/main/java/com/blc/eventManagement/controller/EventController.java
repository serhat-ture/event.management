package com.blc.eventManagement.controller;

import com.blc.eventManagement.dto.EventDto;
import com.blc.eventManagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping("/users/{userId}/events")
    public ResponseEntity<EventDto> createEvent(@PathVariable(value = "userId") Long userId,
                                                    @RequestBody EventDto eventDto) {
        return new ResponseEntity<>(eventService.createEvent(userId, eventDto), HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}/events")
    public List<EventDto> getEventsById(@PathVariable(value = "userId") Long userId) {
        return eventService.getEventsByUserId(userId);

    }

    @GetMapping("/users/{userId}/events/{id}")
    public ResponseEntity<EventDto> getEventById(@PathVariable(value = "userId") Long userId,
                                                     @PathVariable(value = "id") Long eventId) {
        EventDto eventDto = eventService.getEventById(userId, eventId);
        return new ResponseEntity<>(eventDto, HttpStatus.OK);
    }

    @PutMapping("/users/{userId}/events/{id}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable(value = "userId") Long userId,
                                                    @PathVariable(value = "id") Long eventId,
                                                    @RequestBody EventDto eventDto) {

        EventDto updatedEvent = eventService.updateEvent(userId, eventId, eventDto);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}/events/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable(value = "userId") Long userId,
                                                @PathVariable(value = "id") Long eventId) {
        eventService.deleteEvent(userId, eventId);
        return new ResponseEntity<>("Event deleted successfully", HttpStatus.OK);
    }


}
