package com.xworkz.clothingcompany.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClothDto {

    private String clothName;
    private String clothType;
    private String brand;
    private String color;
    private String size;
    private double price;
    private String material;
    private String gender;
}
