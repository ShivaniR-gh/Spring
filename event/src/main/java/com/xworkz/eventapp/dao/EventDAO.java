package com.xworkz.eventapp.dao;

import com.xworkz.eventapp.entity.EventEntity;

import javax.swing.text.html.parser.Entity;

public interface EventDAO {
    boolean save(EventEntity event);
    boolean update(EventEntity event);
    boolean delete(EventEntity event);
    EventEntity read(int id);
}
