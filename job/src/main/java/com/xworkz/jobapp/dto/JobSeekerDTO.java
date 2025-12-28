package com.xworkz.jobapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobSeekerDTO {

    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    private String experienceType;

    private String companyName;
    private String jobTitle;
    private String fromDate;
    private String lastWorkingDate;

    private String professionalSummary;
    private String skills;
}
