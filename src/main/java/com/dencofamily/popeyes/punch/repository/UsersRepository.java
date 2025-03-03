package com.dencofamily.popeyes.punch.repository;

import com.dencofamily.popeyes.punch.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int saveUser(Users users){
        String sql = "INSERT INTO users(username,email,password,phone) VALUES (?,?,?,?)";
        return jdbcTemplate.update(sql,users.getUsername(),users.getEmail(),users.getPassword(),users.getPhone());
    }

    public Users findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Users.class), email);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
