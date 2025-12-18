package com.xworkz.app.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MedicineDTO {

    private int id;
    private String medicineName;
    private String mg;
    private double price;
    private String expiryDate;
}
