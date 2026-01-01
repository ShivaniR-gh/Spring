package com.xworkz.foodapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "")
public class FoodStallDTO {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "stall_name")
    private String stallName;

    @Column(name = "food_type")
    private String foodType;

    @Column(name = "location")
    private String location;


}
