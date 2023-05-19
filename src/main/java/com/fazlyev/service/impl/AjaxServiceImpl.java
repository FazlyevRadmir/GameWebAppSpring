package com.fazlyev.service.impl;

import com.fazlyev.service.AjaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;

@Service
public class AjaxServiceImpl implements AjaxService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AjaxServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean checkingForTheExistenceOfUser(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        return jdbcTemplate.query(sql, new Object[]{username}, ResultSet::next);
    }
}
