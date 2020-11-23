import java.sql.*;
import java.util.ArrayList;

public class DBManager {

    private String tableName="sla_table";
    private Connection con;
    private static DatabaseMetaData metaData;
    private ResultSet rs;
    private ArrayList<String> collumArray= new ArrayList<String>();

    public DBManager(Connection c) throws SQLException {
       con=c;
       metaData=c.getMetaData();
       rs=metaData.getColumns(null, null , tableName,null);
       while(rs.next())
       {
         collumArray.add(rs.getString("COLUMN_NAME"));
       }
    }

    public ArrayList<String> getSLAList()
    {
        return collumArray;
    }

    public ResultSet getAllEntries() throws SQLException {
        String query="SELECT * from "+tableName;
        return con.createStatement().executeQuery(query);
    }

    public ArrayList<Integer> executeQuery(String query) throws SQLException {
        ArrayList<Integer> list=new ArrayList<>();
        rs=con.createStatement().executeQuery(query);
        while(rs.next())
        {
            list.add(rs.getInt(1));
        }
        return list;
    }

    public String getSpecific(String collum,int id) throws SQLException {
        String entry="";
        rs=con.createStatement().executeQuery("SELECT "+collum +" from "+tableName+" WHERE sla_id="+id);
        while(rs.next())
        {

            entry=rs.getString(1);
        }
        return entry;
    }
    public String getTableName() {
        return tableName;
    }
}
