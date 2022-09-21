package jdbc;

import jdbc.unit.JdbcUnit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = JdbcUnit.JdbcUnit();
        Statement statement = null;
        try{
            statement = connection.createStatement();
            for (int i=0;i<20;i++){
                String name = "vietanhvs "+i;
                int age = 10+i;
                String sql = "insert into vanh_student(id, name,age) values "+
                        "("+"vanh_student_seq.nextval"+",'"+name+"',"+age+")";
                statement.addBatch(sql);
            }
            statement.executeBatch();
            ResultSet rs = statement.executeQuery("select count(*) from vanh_student");
            if(rs.next()){
                System.out.println("total records = "+rs.getInt(1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            statement.getConnection().close();
        }
    }
}
