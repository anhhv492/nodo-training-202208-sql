package jdbc;

import jdbc.unit.JdbcUnit;

import java.sql.*;

public class DbFunction {
    public static void getAge(String name,int[] ages) throws SQLException {
        Connection connection = JdbcUnit.JdbcUnit();
        Statement statement =null;
        try {
            statement =connection.createStatement();
            String sql = "select max(age) from vanh_student where name like '%"+name+"%'";
            ResultSet rs= statement.executeQuery(sql);
            ages[0] = rs.next()?rs.getInt(1):-1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            statement.getConnection().close();
        }
    }

    public static void main(String[] args) throws SQLException {
        int[] ages = new int[1];
        getAge("Ha",ages);
        System.out.println(ages[0]);
    }
}
