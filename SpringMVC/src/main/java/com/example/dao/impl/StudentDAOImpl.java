package com.example.dao.impl;

import com.example.dao.StudentDAO;
import com.example.model.Student;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Component
public class StudentDAOImpl implements StudentDAO, DisposableBean {
    @Autowired
    StudentDAO studentDAO;
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;

    @Override
    public void setDataSource(){

    }
    @Override
    public void createTableIfNotExist(){

    }
    @Override
    public List<Student> listStudent() {
        String sql="select*from vanh_student order by id asc";
        return jdbcTemplate.query(sql,new StudentRowMapper());
    }

    @Override
    public Student findById(Integer id) {
        String sql="select*from vanh_student where id="+id;
        return jdbcTemplate.queryForObject(sql,new StudentRowMapper());
    }

    @Override
    public void insert(Student student) {
       try {
           jdbcTemplate.update("insert into vanh_student(id, name,age)" +
                   "values (vanh_student_seq.nextval,?,?)",student.getName(),student.getAge());
           System.out.println("Created record name = "+student.getName());
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    @Override
    public void update(Student student) {
        try {
            jdbcTemplate.update("update vanh_student set name=?, age=? where id=?",
                    student.getName(),student.getAge(),student.getId());
            System.out.println("update success!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            this.jdbcTemplate.update("delete from vanh_student where id = ?",id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public StudentDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void destroy() throws Exception {
        DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl");

    }
    private final static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            try {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                return student;
            }catch (Exception e){
                return null;
            }
        }
    }
}
