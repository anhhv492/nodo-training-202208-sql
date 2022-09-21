package jdbc;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcFirstExample {
    public static void main(String[] args) throws Exception{
        Connection connection=null;
        Statement statement = null;
        String dbUrl = "jdbc:oracle:thin:@27.118.22.14:1521:orcl";
        String username = "SCOTT";
        String password = "SCOTT";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(dbUrl,username,password);
            System.out.println("create database successful!");
            statement= connection.createStatement();
            String sql = "create table vanh_student(\n" +
                    "    id number(4) primary key,\n" +
                    "    genereted int unique ,\n" +
                    "    name varchar2(100),\n" +
                    "    age int default (20)\n" +
                    ")";
            System.out.println(statement.executeUpdate(sql));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
