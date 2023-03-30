package com.blc.eventManagement.dto;

//import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

//import java.time.LocalDate;

@Data
public class EventDto {
    private Long id;
    private String eventName;
    //@JsonFormat(pattern="yyyy-MM-dd")
    private String start;
   // @JsonFormat(pattern="yyyy-MM-dd")
    private String finish;
    private int quota;
    private int participants;

    }
