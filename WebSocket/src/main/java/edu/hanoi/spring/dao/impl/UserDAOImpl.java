package edu.hanoi.spring.dao.impl;

import edu.hanoi.spring.dao.UserDAO;
import edu.hanoi.spring.model.Group;
import edu.hanoi.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public String insert(User user) {
        try {
            System.out.println(user.getGroup().getId()+" id group");
            jdbcTemplate.update("INSERT INTO hn_user (username, email, password, age, groupId)VALUES (?,?,?,?,?)",
                    user.getUsername(),user.getEmail(),user.getPassword(),user.getAge(),user.getGroup().getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "ok";
    }

    @Override
    public void delete(String name) {

    }

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public User getByName(String name) {
        return null;
    }

    @Override
    public void update(User user) {

    }
}
