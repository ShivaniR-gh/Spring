package com.xworkz.jobapp.service;

import com.xworkz.jobapp.dto.JobSeekerDTO;

import java.util.List;
import java.util.Optional;

public interface JobAccountService {


        boolean validateAndSave(JobSeekerDTO dto);

        Optional<JobSeekerDTO> findByEmail(String email);

        List<JobSeekerDTO> findAll();

        boolean update(JobSeekerDTO dto);

        boolean deleteById(int id);
    }
