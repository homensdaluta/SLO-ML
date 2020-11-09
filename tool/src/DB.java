
import java.sql.*;

public class DB {

    private final String URL = "jdbc:mysql://localhost/tests";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";
    private Connection c=null;

    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("yey");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public void close()
    {
        try {
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }
}
