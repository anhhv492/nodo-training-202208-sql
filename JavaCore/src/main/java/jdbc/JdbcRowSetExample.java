package jdbc;

import jdbc.unit.JdbcUnit;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcRowSetExample {
    public static void main(String[] args) {
        try {
            JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
            jdbcRowSet.setUrl("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");
            jdbcRowSet.setCommand("select*from vanh_student");
            jdbcRowSet.execute();
            while (jdbcRowSet.next()){
                System.out.println(jdbcRowSet.getInt(1)+"\t"+jdbcRowSet.getString("name"));
            }
            jdbcRowSet.first();
//            jdbcRowSet.setCommand("update vanh_student set name='vietanhnew' where id=2");
            jdbcRowSet.setString(2,"Hạ Việt Anh");
            jdbcRowSet.setAutoCommit(true);
            jdbcRowSet.first();
            System.out.println(jdbcRowSet.getInt("id")+"\t"+jdbcRowSet.getInt(2));
            jdbcRowSet.absolute(8);
            System.out.println(jdbcRowSet.getInt("id")+"\t"+jdbcRowSet.getString(3));
            jdbcRowSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
