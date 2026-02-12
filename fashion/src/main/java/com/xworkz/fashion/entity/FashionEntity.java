package com.xworkz.fashion.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "fashion")
public class FashionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "cloth_name")
    private String clothName;
    @Column(name = "cloth_brand")
    private String clothBrand;
    @Column(name = "cloth_price")
    private double clothPrice;
    @Column(name = "cloth_size")
    private int clothSize;

}
