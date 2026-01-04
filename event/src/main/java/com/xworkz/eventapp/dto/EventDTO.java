package com.xworkz.eventapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EventDTO {
    private int id;
    private String eventName;
    private String eventManager;
    private String location;
    private String eventType;
}







