package jdbc.unit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcUnit {
    public static Connection JdbcUnit(){
        Connection connection=null;
        Statement statement = null;
        String dbUrl = "jdbc:oracle:thin:@27.118.22.14:1521:orcl";
        String username = "SCOTT";
        String password = "SCOTT";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(dbUrl,username,password);
            statement = connection.createStatement();
            System.out.println("create database successful!");
        }catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
