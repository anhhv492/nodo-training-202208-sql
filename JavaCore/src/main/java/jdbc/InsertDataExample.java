package jdbc;

import jdbc.unit.JdbcUnit;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataExample {
    public static void main(String[] args) throws SQLException {
        Statement statement = null;
        try{
            Connection connection = JdbcUnit.JdbcUnit();
            statement = connection.createStatement();
            String sql1 ="insert into vanh_student(id, genereted, name,age)" +
                            "values (vanh_student_seq.nextval,1,'viet anh',12)";
            statement.execute(sql1);
            String sql2 ="insert into vanh_student(id, genereted, name,age)" +
                    "values (vanh_student_seq.nextval,2,'ninja',32)";
            statement.execute(sql2);
            String sql3 ="insert into vanh_student(id, genereted, name,age)" +
                    "values (vanh_student_seq.nextval,3,'school',22)";
            statement.execute(sql3);
        }finally {
            statement.getConnection().close();
        }
    }
}
