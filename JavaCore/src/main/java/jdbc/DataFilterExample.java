package jdbc;

import jdbc.unit.JdbcUnit;

import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;

public class DataFilterExample {
    public static void main(String[] args) {
        Connection connection= JdbcUnit.JdbcUnit();
        try {
            FilteredRowSet frs = RowSetProvider.newFactory().createFilteredRowSet();
            frs.setUrl("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");
            frs.setCommand("select * from vanh_student");
            frs.setFilter(new DataFilter());
            frs.execute();
            System.out.println("ID\tName\t\tAge");
            while (frs.next()){
                System.out.println(frs.getInt("id")+"\t"+frs.getString("name")+"\t"+frs.getInt("age"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
