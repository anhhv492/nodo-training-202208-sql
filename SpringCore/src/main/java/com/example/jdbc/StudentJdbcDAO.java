package com.example.jdbc;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbcDAO {
    private static Logger LOGGER = Logger.getLogger(StudentJdbcDAO.class);
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private PlatformTransactionManager transactionManager = new PlatformTransactionManager() {
        @Override
        public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
            return null;
        }

        @Override
        public void commit(TransactionStatus status) throws TransactionException {

        }

        @Override
        public void rollback(TransactionStatus status) throws TransactionException {

        }
    };
    private String insertQuery;
    private String updateQuery;
    private String deleteQuery;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
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
    //crud
    public List<Student> loadStudent(String name){
        String sql="select*from va_students where name like '%"+name+"%'";
        return jdbcTemplate.query(sql,new StudentRowMapper());
    }
    public List<Student> loadAllStudent(){
        String sql="select*from va_students order by id asc";
        return jdbcTemplate.query(sql,new StudentRowMapper());
    }
    public void insert(int id,String name,int age){
        jdbcTemplate.update(insertQuery,id,name,age);
        LOGGER.info("Created record name = "+name+"age= "+age);
    }
    public void updateAgeById(int id,int age){
        jdbcTemplate.update(updateQuery,age,id);
    }
    public void deleteAgeById(int id){
        jdbcTemplate.update(deleteQuery,id);
    }
    public int[] add(List<Student> students){
        List<Object[]> batch=new ArrayList<>();
        students.forEach(student->batch.add(new Object[]{
                student.getId(),student.getName(),student.getAge()
        }));
        return jdbcTemplate.batchUpdate(insertQuery,batch);
    }
    public void save(Object id,Object name,Object age){
        TransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(definition);
        String countQuery="select count(*) from va_students";
        int total=0;
        try {
            total = jdbcTemplate.queryForObject(countQuery,Integer.class);
            LOGGER.info("- Before save data, total record is: "+total);

            String sql = "insert into va_students(id,name,age) values(?,?,?)";
            jdbcTemplate.update(sql,id,name,age);

            total = jdbcTemplate.queryForObject(countQuery,Integer.class);
            LOGGER.info("- After save data, total record is: "+total);

            String countQuery2 = "select count(*) from va_students";
            total = jdbcTemplate.queryForObject(countQuery2,Integer.class);

            transactionManager.commit(status);
        } catch (Exception e){
            transactionManager.rollback(status);
            total = jdbcTemplate.queryForObject(countQuery,Integer.class);
            LOGGER.info("- After rollback, total record is: "+total);
            e.printStackTrace();
        }
    }
    //-----------------------------------------------------//
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

    public String getUpdateQuery() {
        return updateQuery;
    }

    public void setUpdateQuery(String updateQuery) {
        this.updateQuery = updateQuery;
    }

    public String getDeleteQuery() {
        return deleteQuery;
    }

    public void setDeleteQuery(String deleteQuery) {
        this.deleteQuery = deleteQuery;
    }

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

}
