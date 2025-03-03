package com.dencofamily.popeyes.punch.dao;

import com.dencofamily.popeyes.punch.model.XenialEEChanges;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class XenialEEChangesDao {

    private final JdbcTemplate jdbcTemplate;

    public XenialEEChangesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<XenialEEChanges> getAllChanges() {
        String sql = """
            SELECT a.id, a.change_desc, a.change_time, a.changed_by, a.created_at,
                   a.ee_code, a.ee_name, a.employee_id, a.is_updated, a.log_details,
                   a.new_value, a.old_value, a.site_id, a.event_id,
                   b.client_code, b.endpoint, b.endpoint_url, b.event_date_time,
                   b.event_name, b.object, b.object_identifier, b.resource_field
            FROM xenial_eechanges_event_api_response a
            LEFT JOIN xenial_eechanges_event_record b ON b.id = a.event_id
            ORDER BY a.change_time DESC
            """;

        List<XenialEEChanges> changes = jdbcTemplate.query(sql, new XenialEEChangesRowMapper());

        System.out.println("Query executed. Retrieved " + changes.size() + " records.");
        return changes;
    }


    private static class XenialEEChangesRowMapper implements RowMapper<XenialEEChanges> {
        @Override
        public XenialEEChanges mapRow(ResultSet rs, int rowNum) throws SQLException {
            XenialEEChanges change = new XenialEEChanges();
            change.setId(rs.getLong("id"));
            change.setChangeDesc(rs.getString("change_desc"));
            change.setChangeTime(rs.getString("change_time"));
            change.setChangedBy(rs.getString("changed_by"));
            change.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            change.setEeCode(rs.getString("ee_code"));
            change.setEeName(rs.getString("ee_name"));
            change.setEmployeeId(rs.getString("employee_id"));
            change.setUpdated(rs.getBoolean("is_updated"));
            change.setLogDetails(rs.getString("log_details"));
            change.setNewValue(rs.getString("new_value"));
            change.setOldValue(rs.getString("old_value"));
            change.setSiteId(rs.getString("site_id"));
            change.setEventId(rs.getLong("event_id"));

            // From the second table
            change.setClientCode(rs.getString("client_code"));
            change.setEndpoint(rs.getString("endpoint"));
            change.setEndpointUrl(rs.getString("endpoint_url"));
            change.setEventDateTime(rs.getLong("event_date_time"));
            change.setEventName(rs.getString("event_name"));
            change.setObject(rs.getString("object"));
            change.setObjectIdentifier(rs.getString("object_identifier"));
            change.setResourceField(rs.getString("resource_field"));

            return change;
        }
    }
}
