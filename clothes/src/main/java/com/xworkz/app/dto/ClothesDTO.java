package com.xworkz.app.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class ClothesDTO {
    private int id;
    private String clothesName;
    private String clothesBrand;
    private double clothesPrice;
    private String clothesType;

}
