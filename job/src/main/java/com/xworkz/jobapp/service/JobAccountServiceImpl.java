package com.xworkz.jobapp.service;

import com.xworkz.jobapp.dao.JobAccountDAO;
import com.xworkz.jobapp.dto.JobSeekerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JobAccountServiceImpl implements JobAccountService{
    @Autowired
    private JobAccountDAO dao;

    @Override
    public boolean validateAndSave(JobSeekerDTO dto) {

        if (dto == null) {
            return false;
        }

        if (dto.getFirstName() == null || dto.getEmail() == null) {
            return false;
        }

        if ("Experienced".equalsIgnoreCase(dto.getExperienceType())) {
            if (dto.getCompanyName() == null || dto.getJobTitle() == null) {
                return false;
            }
        }

        return dao.save(dto);
    }


    @Override
    public Optional<JobSeekerDTO> findByEmail(String email) {
        if(email == null || email.isEmpty()) {
            return Optional.empty();
        }
        return dao.findByEmail(email);
    }

    @Override
    public List<JobSeekerDTO> findAll() {
        return dao.findAll();
    }

    @Override
    public boolean update(JobSeekerDTO dto) {
        if (dto == null || dto.getId() <= 0){
            return false;
        }
        return dao.update(dto);
    }

    @Override
    public boolean deleteById(int id) {
        if(id <= 0) {
            return false;
        }
        return dao.deleteById(id);
    }
}
