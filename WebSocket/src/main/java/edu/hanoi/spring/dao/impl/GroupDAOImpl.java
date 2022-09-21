package edu.hanoi.spring.dao.impl;

import edu.hanoi.spring.dao.GroupDAO;
import edu.hanoi.spring.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupDAOImpl implements GroupDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<Group> list() {
        return null;
    }

    @Override
    public Group getById(Integer id) {
        try{
//            Group group = jdbcTemplate.query("select p from Group p where p.id=?");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
