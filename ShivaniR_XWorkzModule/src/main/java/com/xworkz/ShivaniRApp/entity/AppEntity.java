package com.xworkz.ShivaniRApp.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "App")
public class AppEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column (name = "name")
    private String name;
    @Column (name = "email")
    private String email;
    @Column(name = "phone_number")
    private long phoneNumber;
    @Column(name = "age")
    private int age;
    @Column (name ="gender")
    private String gender;
    @Column (name = "password")
    private String password;

}
