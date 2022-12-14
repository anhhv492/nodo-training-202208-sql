package edu.hanoi.spring.dao;

import edu.hanoi.spring.model.User;

import java.util.List;

public interface UserDAO {
    public String insert(User user);
    public void delete(String name);
    public List<User> list();
    public User getByName(String name);
    public void update(User user);
}
