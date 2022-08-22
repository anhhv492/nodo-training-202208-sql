package jdbc;

import jdbc.unit.JdbcUnit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TransactionExample {
    public static void main(String[] args) {
        try{
            Connection connection = JdbcUnit.JdbcUnit();
            Statement statement = connection.createStatement();
            for(int i=0;i<10;i++){
                String name = "Ha Viet "+i;
                int age = 10+i;
                int genereted=4+i;
                String sql = "insert into vanh_student(id, genereted, name,age)" +
                        "values (vanh_student_seq.nextval,"+genereted+","+name+","+age+")";
//                String sql = "insert into vanh_student(id, genereted, name,age) values "+
//                        "("+"vanh_student_seq.nextval"+","+genereted+")";
                statement.executeUpdate(sql);
            }
            connection.rollback();
            connection.setAutoCommit(true);
            String sqlCountST="select count(*) from vanh_student";
            ResultSet rs = statement.executeQuery(sqlCountST);
            statement.getConnection().close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
