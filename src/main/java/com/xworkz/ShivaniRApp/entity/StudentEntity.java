package com.xworkz.ShivaniRApp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String phone;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    private BatchEntity batch;

    @Column(name = "photo_path")
    private String photoPath;

}
