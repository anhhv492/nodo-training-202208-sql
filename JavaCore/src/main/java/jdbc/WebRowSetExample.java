package jdbc;

import jdbc.unit.JdbcUnit;

import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WebRowSetExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = JdbcUnit.JdbcUnit();
        Statement statement=null;
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select*from vanh_student");
            File file = new File("output.xml");
            FileWriter writer = new FileWriter(file);
            WebRowSet wrs = RowSetProvider.newFactory().createWebRowSet();
            wrs.writeXml(rs,writer);
            Desktop.getDesktop().open(file);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            statement.getConnection().close();
        }
    }
}
