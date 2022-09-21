package jdbc;

import jdbc.unit.JdbcUnit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDataExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = JdbcUnit.JdbcUnit();
        String sql = "update vanh_student set name=? where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,"vietanhvs");
        statement.setInt(2,2);
        statement.executeUpdate();
        System.out.println("update success!");
        statement.getConnection().close();
    }
}
