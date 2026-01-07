package com.xworkz.clothingcompany.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cloth_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(
        name = "findAll",
        query = "select c from ClothEntity c"
)
public class ClothEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String clothName;
    private String clothType;
    private String brand;
    private String color;
    private String size;
    private double price;
    private String material;
    private String gender;
}
