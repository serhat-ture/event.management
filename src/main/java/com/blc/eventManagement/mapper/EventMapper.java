package com.blc.eventManagement.mapper;
import com.blc.eventManagement.dto.EventDto;
import com.blc.eventManagement.model.Event;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    @Autowired
    private ModelMapper modelMapper;

    public EventDto mapToDTO(Event event) {
        EventDto eventDto = modelMapper.map(event, EventDto.class);
        return eventDto;
    }

    public Event mapToEntity(EventDto eventDto) {
        Event event = modelMapper.map(eventDto, Event.class);
        return event;
    }
}
