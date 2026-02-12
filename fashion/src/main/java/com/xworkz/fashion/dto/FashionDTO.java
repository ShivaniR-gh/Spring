package com.xworkz.fashion.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FashionDTO {

    private int id;
    private String clothName;
    private String clothBrand;
    private double clothPrice;
    private int clothSize;

}
