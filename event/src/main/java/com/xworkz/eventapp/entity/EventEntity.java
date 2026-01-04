package com.xworkz.eventapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "event")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @Column(name = "event_name")
    private String eventName;
    @Column(name = "event_manager")
    private String eventManager;
    @Column(name = "event_location")
    private String location;
    @Column(name = "event_type")
    private String eventType;
}
