package com.xworkz.jobapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="job_seeker")
public class JobSeekerDTO {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;


    @Column(name = "experience_type")
    private String experienceType;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "from_date")
    private String fromDate;
    @Column(name = "lwd")
    private String lastWorkingDate;

    @Column(name = "summary")
    private String professionalSummary;

    @Column(name = "skills")
    private String skills;
}
