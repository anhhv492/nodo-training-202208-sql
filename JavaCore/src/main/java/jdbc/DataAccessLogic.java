package jdbc;

import jdbc.unit.JdbcUnit;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessLogic {
    private final static Logger logger = Logger.getLogger(DataAccessLogic.class.getName());
    Connection connection = null;
    int pageSize=10;
    CachedRowSet rowSet;
    public DataAccessLogic(){
        this.connection = JdbcUnit.JdbcUnit();
        try {
            rowSet = RowSetProvider.newFactory().createCachedRowSet();
            rowSet.setCommand("select * from vanh_student");
            rowSet.execute(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    int numberOfPage() throws SQLException {
        Connection connection= JdbcUnit.JdbcUnit();
        Statement statement =null;
        try {
            statement=connection.createStatement();
            ResultSet rs = statement.executeQuery("select count(*) from vanh_student");
            if(!rs.next()){
                return 0;
            }
            int total = rs.getInt(1);
            int totalPage = total/pageSize;
            if(total%pageSize!=0){
                totalPage++;
            }
            return totalPage;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            statement.getConnection().close();
        }
        return 0;
    }

    public void disconnect(){
        try {
            if(connection!=null){
                connection.close();
            }
        }catch (Exception e){
            logger.log(Level.WARNING,e.toString());
        }
    }
    List<String> loadNames(int page){
        try {
            List<String> names=new ArrayList<>();
            rowSet.setPageSize(pageSize);
            int start = (page-1)*pageSize+1;
            if(!rowSet.absolute(start)){
                return names;
            }
            rowSet.previous();
            while (rowSet.next()){
                names.add(rowSet.getString("name"));
                if(names.size()>=pageSize){
                    break;
                }
            }
            return names;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
