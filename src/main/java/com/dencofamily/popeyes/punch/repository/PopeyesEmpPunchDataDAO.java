package com.dencofamily.popeyes.punch.repository;

import com.dencofamily.popeyes.punch.model.PopeyesEmpPunchData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PopeyesEmpPunchDataDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Fetch all punch data from the popeyes_emp_punch_data table in descending order by ID.
     * @return List of PopeyesEmpPunchData objects
     */
    public List<PopeyesEmpPunchData> fetchAllPunchData() {
        String sql = "SELECT id, store_name, report_date, emp_name, emp_designation, export_id, emp_number, " +
                "work_date, in_time, out_time, break_in_time, break_out_time, pd_break_min, unpd_break_min, " +
                "rate, reg_hrs, reg_pay, ot_rate, ot_hours, ot_pay, total_hrs, total_pay, CCTips, DeclTips, " +
                "TippableSales, TipSales_0_08, status, filename, created_at " +
                "FROM popeys_emp_punch_data ORDER BY id DESC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PopeyesEmpPunchData.class));
    }
}
