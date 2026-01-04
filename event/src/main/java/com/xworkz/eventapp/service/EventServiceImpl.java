package com.xworkz.eventapp.service;

import com.xworkz.eventapp.dao.EventDAO;
import com.xworkz.eventapp.dao.EventDAOImpl;
import com.xworkz.eventapp.dto.EventDTO;
import com.xworkz.eventapp.entity.EventEntity;
import org.springframework.beans.BeanUtils;

public class EventServiceImpl implements EventService {


    EventDAO eventDAO = new EventDAOImpl();

    @Override
    public boolean validateAndSave(EventDTO eventDTO) {


        EventEntity entity = new EventEntity();
        BeanUtils.copyProperties(eventDTO , entity);
        boolean saved = eventDAO.save(entity);

        return saved;
    }

    @Override
    public boolean update(EventDTO eventDTO) {
        EventEntity entity = new EventEntity();
        BeanUtils.copyProperties(eventDTO , entity);
        boolean saved = eventDAO.update(entity);
        return saved;
    }
    @Override
    public boolean delete(EventDTO eventDTO) {
        EventEntity entity = new EventEntity();
        BeanUtils.copyProperties(eventDTO , entity);
        boolean saved = eventDAO.delete(entity);
        return saved;
    }
    @Override
    public EventDTO findById(int id) {

        EventEntity entity = eventDAO.read(id);

        if (entity != null) {
            EventDTO dto = new EventDTO();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        }
        return null;
    }


}
