package com.example.jdbc;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class StudentJdbcDAO {
    private static Logger LOGGER = Logger.getLogger(StudentJdbcDAO.class);
    @Autowired
    private DataSource dataSource;
    private String insertQuery;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public void insert(int id,String name,int age){
        jdbcTemplate.update(insertQuery,id,name,age);
        LOGGER.info("Created record name = "+name+"age= "+age);
    }
    private void createTableIfNotExist() throws SQLException {
            DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
            ResultSet rs = dbmd.getTables(null,null,"va_students",null);
            if(rs.next()){
                LOGGER.info("Table"+rs.getString("name"+"already"));
                return;
            }
            String sql ="create table va_students(\n" +
                    "    id number(4) primary key ,\n" +
                    "    name varchar2(100),\n" +
                    "    age int\n" +
                    ")";
            jdbcTemplate.execute(sql);
            System.out.println("success !");
    }

    public static Logger getLOGGER() {
        return LOGGER;
    }

    public static void setLOGGER(Logger LOGGER) {
        StudentJdbcDAO.LOGGER = LOGGER;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getInsertQuery() {
        return insertQuery;
    }

    public void setInsertQuery(String insertQuery) {
        this.insertQuery = insertQuery;
    }
    public int totalRecord(){
        return jdbcTemplate.execute((Statement statement)->{
            ResultSet rs = statement.executeQuery("select count(*) from va_students");
            int count=0;
            while (rs.next()){
                count = rs.getInt(1);
            }
            return count;
        });
//        return jdbcTemplate.execute(new StatementCallback<Integer>() {
//            @Override
//            public Integer doInStatement(Statement stmt) throws SQLException, DataAccessException {
//                Connection connection = dataSource.getConnection();
//                Statement statement = connection.createStatement();
//                ResultSet rs = statement.executeQuery("select count(*) from va_students");
//                return rs.next()?rs.getInt(1):0;
//            }
//        });
    }
    private final static class StudentRowMapper implements RowMapper<Student>{
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            try {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                return student;
            }catch (Exception e){
                LOGGER.error(e,e);
                return null;
            }
        }
    }
    public List<Student> loadStudent(String name){
        String sql="select*from va_students where name like '%"+name+"%'";
        return jdbcTemplate.query(sql,new StudentRowMapper());
    }
    public void updateAgeById(int id,int age){
        String updateAgeByNameSQL = "update va_students set age=? where id=?";
        jdbcTemplate.update(updateAgeByNameSQL,age,id);
    }
}
