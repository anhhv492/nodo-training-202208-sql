package jdbc;

import jdbc.unit.JdbcUnit;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStoredProcedureExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = JdbcUnit.JdbcUnit();
        Statement statement=null;
        try {
            statement = connection.createStatement();
            String sqlCrPro = "create procedure vanh_getage_pro(stream_name varchar2(100), out_age int )\n" +
                    "is\n" +
                    "begin\n" +
                    "    select*from vanh_student where name = stream_name and age=out_age;\n" +
                    "end;";
            statement.executeUpdate(sqlCrPro);
            System.out.println("create procedure success!");
        }catch (Exception e){
            System.out.println("Error: procedure is already!");
            statement.getConnection().close();
        }
    }
}
