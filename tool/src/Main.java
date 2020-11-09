import java.sql.ResultSet;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        DB db = new DB();
        DBManager manager;
        ResultSet rs;
        Selector selector;
        try
        {
            manager= new DBManager(db.getConnection());
            selector= new Selector(manager);
            ArrayList<String> list=manager.getSLAList();
            ArrayList<Integer> idlist = manager.executeQuery("SELECT * from "+manager.getTableName());
            rs=manager.getAllEntries();
            while(rs.next())
            {
                for(String text : list)
                {
                    System.out.println(rs.getString(text));
                }
                System.out.println("------------------------------");
            }
            System.out.println("------------------------------");
            selector.addSLO(new SLO("MUP",99.95,"<="));
            selector.addSLO(new SLO("RTO",40,">="));

            selector.select();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
