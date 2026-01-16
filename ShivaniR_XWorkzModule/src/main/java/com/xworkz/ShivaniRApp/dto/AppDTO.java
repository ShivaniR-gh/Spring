package com.xworkz.ShivaniRApp.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppDTO {
    private int id;
    private String name;
    private String email;
    private long phoneNumber;
    private int age;
    private String gender;
    private String password;

}
