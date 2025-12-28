package com.xworkz.jobapp.dao;

import com.xworkz.jobapp.dto.JobSeekerDTO;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class JobAccountDAOImpl implements JobAccountDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/job";
    private static final String USER = "root";
    private static final String PASSWORD = "Shivani@2025";


    @SneakyThrows
    @Override
    public boolean save(JobSeekerDTO jobSeekerDTO) {

        String sql = "INSERT INTO job_seeker " +
                "(first_name, last_name, email, phone, address, experience_type, company_name, job_title, from_date, lwd, summary, skills) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, jobSeekerDTO.getFirstName());
            ps.setString(2, jobSeekerDTO.getLastName());
            ps.setString(3, jobSeekerDTO.getEmail());
            ps.setString(4, jobSeekerDTO.getPhone());
            ps.setString(5, jobSeekerDTO.getAddress());
            ps.setString(6, jobSeekerDTO.getExperienceType());
            ps.setString(7, jobSeekerDTO.getCompanyName());
            ps.setString(8, jobSeekerDTO.getJobTitle());
            ps.setString(9, jobSeekerDTO.getFromDate());
            ps.setString(10, jobSeekerDTO.getLastWorkingDate());
            ps.setString(11, jobSeekerDTO.getProfessionalSummary());
            ps.setString(12, jobSeekerDTO.getSkills());

            int rows = ps.executeUpdate();
            return rows > 0;

        }
    }

    @SneakyThrows
    @Override
    public Optional<JobSeekerDTO> findByEmail(String email) {
        String sql = "select * from job_seeker where email = ? ";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                JobSeekerDTO dto = new JobSeekerDTO();
                dto.setId(rs.getInt("id"));
                dto.setFirstName(rs.getString("first_name"));
                dto.setLastName(rs.getString("last_name"));
                dto.setEmail(rs.getString("email"));
                dto.setPhone(rs.getString("phone"));
                dto.setAddress(rs.getString("address"));
                dto.setExperienceType(rs.getString("experience_type"));
                dto.setCompanyName(rs.getString("company_name"));
                dto.setJobTitle(rs.getString("job_title"));
                dto.setFromDate(rs.getString("from_date"));
                dto.setLastWorkingDate(rs.getString("lwd"));
                dto.setProfessionalSummary(rs.getString("summary"));
                dto.setSkills(rs.getString("skills"));

                return Optional.of(dto);
            }
        }
        return Optional.empty();
    }


    @SneakyThrows
    @Override
    public List<JobSeekerDTO> findAll() {

        String sql = "select * from job_seeker";
        List<JobSeekerDTO> list = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                JobSeekerDTO dto = new JobSeekerDTO();

                dto.setId(rs.getInt("id"));
                dto.setFirstName(rs.getString("first_name"));
                dto.setLastName(rs.getString("last_name"));
                dto.setEmail(rs.getString("email"));
                dto.setPhone(rs.getString("phone"));
                dto.setAddress(rs.getString("address"));
                dto.setExperienceType(rs.getString("experience_type"));
                dto.setCompanyName(rs.getString("company_name"));
                dto.setJobTitle(rs.getString("job_title"));
                dto.setFromDate(rs.getString("from_date"));
                dto.setLastWorkingDate(rs.getString("lwd"));
                dto.setProfessionalSummary(rs.getString("summary"));
                dto.setSkills(rs.getString("skills"));

                list.add(dto);
            }
        }
        return list;
    }

    @SneakyThrows
    @Override
    public boolean update(JobSeekerDTO dto) {
        String sql = "UPDATE job_seeker SET " +
                "first_name=?, last_name=?, phone=?, address=?, experience_type=?, company_name=?, job_title=?, from_date=?, lwd=?, summary=?, skills=? " +
                "WHERE id=?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dto.getFirstName());
            ps.setString(2, dto.getLastName());
            ps.setString(3, dto.getPhone());
            ps.setString(4, dto.getAddress());
            ps.setString(5, dto.getExperienceType());
            ps.setString(6, dto.getCompanyName());
            ps.setString(7, dto.getJobTitle());
            ps.setString(8, dto.getFromDate());
            ps.setString(9, dto.getLastWorkingDate());
            ps.setString(10, dto.getProfessionalSummary());
            ps.setString(11, dto.getSkills());
            ps.setInt(12, dto.getId());

            int rows = ps.executeUpdate();
            return rows > 0;
        }

    }

    @SneakyThrows
    @Override
    public boolean deleteById(int id) {
        String sql = "delete from job_seeker where id = ? ";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}