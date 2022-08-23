package jdbc;

import jdbc.unit.JdbcUnit;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class JdbcMetadataExample {
    public static void main(String[] args) throws SQLException {
        Connection connection = JdbcUnit.JdbcUnit();
        try {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("db version "+metaData.getDatabaseMajorVersion());
            System.out.println("driver name "+metaData.getDriverName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }
}
