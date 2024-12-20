package com.example.demo.repository;

import com.example.demo.exceptions.UserAlreadyExistsException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.User;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository implements com.example.demo.repository.Repository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UserRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }



    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return namedParameterJdbcTemplate.query(sql, new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setAge(rs.getInt("age"));
                return user;
            }
        }) ;
    }


    public User getUserById(Long id)
    {
        String sql = "SELECT * FROM users WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource("id", id);
        params.addValue("id", id);
        try {
            return namedParameterJdbcTemplate.queryForObject(sql, params, new RowMapper<User>() {
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setName(rs.getString("name"));
                    user.setSurname(rs.getString("surname"));
                    user.setEmail(rs.getString("email"));
                    user.setAge(rs.getInt("age"));
                    return user;
                }
            });
        } catch (EmptyResultDataAccessException e) {
            return null;

        }
    }





    public void addUser(Long id ,String name, String surname, String email , int age) {
        try {
            String sql = "INSERT INTO users (id ,name, surname, email , age) VALUES (:id ,:name, :surname,:email , :age)";
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("id", id);
            params.addValue("name", name);
            params.addValue("surname", surname);
            params.addValue("email", email);
            params.addValue("age", age);

            namedParameterJdbcTemplate.update(sql, params);
        } catch (DuplicateKeyException e) {
            throw new UserAlreadyExistsException("");
        }
    }


    public void deleteUser(Long id) {
        String sql = "DELETE FROM users WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        int rowsAffected = namedParameterJdbcTemplate.update(sql, params);
        if (rowsAffected == 0) {
            throw new UserNotFoundException("");
        }
    }
}
