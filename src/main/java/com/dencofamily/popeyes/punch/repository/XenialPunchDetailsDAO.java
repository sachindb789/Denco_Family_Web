package com.dencofamily.popeyes.punch.repository;

import com.dencofamily.popeyes.punch.model.XenialPunchDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class XenialPunchDetailsDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<XenialPunchDetails> fetchAllPunchDetails() {
        String sql = "SELECT id, EmployeeWorkTimeId, EmployeeId, BusinessDate, ClockIn, ClockInTypeId, " +
                "ClockInTypeName, ClockOut, ClockOutTypeId, ClockOutTypeName, EmployeeCorporateCode, " +
                "Firstname, Lastname, JobCodeId, IsActive, SiteId, is_punch_send, created_at, updated_at " +
                "FROM xenial_punch_details ORDER BY id DESC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(XenialPunchDetails.class));
    }
}
