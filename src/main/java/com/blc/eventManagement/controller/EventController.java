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

    @PostMapping("/persons/{personId}/events")
    public ResponseEntity<EventDto> createEvent(@PathVariable(value = "personId") Long personId,
                                                    @RequestBody EventDto eventDto) {
        return new ResponseEntity<>(eventService.createEvent(personId, eventDto), HttpStatus.CREATED);
    }

    @GetMapping("/persons/{personId}/events")
    public List<EventDto> getEventsByPersonId(@PathVariable(value = "personId") Long personId) {
        return eventService.getEventsByPersonId(personId);

    }

    @GetMapping("/persons/{personId}/events/{id}")
    public ResponseEntity<EventDto> getEventById(@PathVariable(value = "personId") Long personId,
                                                     @PathVariable(value = "id") Long eventId) {
        EventDto eventDto = eventService.getEventById(personId, eventId);
        return new ResponseEntity<>(eventDto, HttpStatus.OK);
    }

    @PutMapping("/persons/{personId}/events/{id}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable(value = "personId") Long personId,
                                                    @PathVariable(value = "id") Long eventId,
                                                    @RequestBody EventDto eventDto) {

        EventDto updatedEvent = eventService.updateEvent(personId, eventId, eventDto);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

    @DeleteMapping("/persons/{personId}/events/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable(value = "personId") Long personId,
                                                @PathVariable(value = "id") Long eventId) {
        eventService.deleteEvent(personId, eventId);
        return new ResponseEntity<>("Event deleted successfully", HttpStatus.OK);
    }


}
