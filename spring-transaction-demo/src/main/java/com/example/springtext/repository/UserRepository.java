package com.example.springtext.repository;

import com.example.springtext.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insert(User user) {
        return jdbcTemplate.update(
                "INSERT INTO user(username, email) VALUES (?, ?)",
                user.getUsername(),
                user.getEmail());
    }
}
