package com.blc.eventManagement.dto;


import lombok.Data;



@Data
public class EventDto {
    private Long id;
    private String eventName;
    private String start;
     private String finish;
    private int quota;
    private int participants;


    }
