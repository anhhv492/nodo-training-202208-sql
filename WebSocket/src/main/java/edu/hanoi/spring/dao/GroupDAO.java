package edu.hanoi.spring.dao;

import edu.hanoi.spring.model.Group;

import java.util.List;

public interface GroupDAO {
    public List<Group> list();
    public Group getById(Integer id);
}
