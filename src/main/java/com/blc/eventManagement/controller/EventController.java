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

    @PostMapping("/citys/{cityId}/events")
    public ResponseEntity<EventDto> createEvent(@PathVariable(value = "cityId") Long cityId,
                                                    @RequestBody EventDto eventDto) {
        return new ResponseEntity<>(eventService.createEvent(cityId, eventDto), HttpStatus.CREATED);
    }

    @GetMapping("/citys/{cityId}/events")
    public List<EventDto> getEventsByCityId(@PathVariable(value = "cityId") Long cityId) {
        return eventService.getEventsByCityId(cityId);

    }

    @GetMapping("/citys/{cityId}/events/{id}")
    public ResponseEntity<EventDto> getEventById(@PathVariable(value = "cityId") Long cityId,
                                                     @PathVariable(value = "id") Long eventId) {
        EventDto eventDto = eventService.getEventById(cityId, eventId);
        return new ResponseEntity<>(eventDto, HttpStatus.OK);
    }

    @PutMapping("/citys/{cityId}/events/{id}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable(value = "cityId") Long cityId,
                                                    @PathVariable(value = "id") Long eventId,
                                                    @RequestBody EventDto eventDto) {

        EventDto updatedEvent = eventService.updateEvent(cityId, eventId, eventDto);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

    @DeleteMapping("/citys/{cityId}/events/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable(value = "cityId") Long cityId,
                                                @PathVariable(value = "id") Long eventId) {
        eventService.deleteEvent(cityId, eventId);
        return new ResponseEntity<>("Event deleted successfully", HttpStatus.OK);
    }


}
