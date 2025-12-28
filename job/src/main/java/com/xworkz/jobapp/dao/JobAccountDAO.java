package com.xworkz.jobapp.dao;

import com.xworkz.jobapp.dto.JobSeekerDTO;

import java.util.List;
import java.util.Optional;

public interface JobAccountDAO {

    boolean save(JobSeekerDTO jobSeekerDTO);

    Optional<JobSeekerDTO> findByEmail(String email);

    List<JobSeekerDTO> findAll();

    boolean update(JobSeekerDTO dto);

    boolean deleteById(int id);
}
