package com.xworkz.productapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ProductDTO {

    private int id;
    private String productName;
    private double price;
    private int quantity;
    private String category;
}
