package jdbc;

import jdbc.unit.JdbcUnit;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDataExample {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JdbcUnit.JdbcUnit();
            statement = connection.createStatement();
            String sql ="select*from vanh_student";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                int id =rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(id+"\t"+name+"\t"+age);
            }
            rs.close();
            statement.getConnection().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
