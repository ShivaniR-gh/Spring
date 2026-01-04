package com.xworkz.eventapp.service;

import com.xworkz.eventapp.dto.EventDTO;
import com.xworkz.eventapp.entity.EventEntity;

public interface EventService {
    boolean validateAndSave(EventDTO eventDTO);
    boolean update(EventDTO eventDTO);
    boolean delete(EventDTO eventDTO);
    EventDTO findById(int id);
}