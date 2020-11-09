
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Selector {

    private DBManager manager;
    private ArrayList<SLO> sloList= new ArrayList<>();
    private HashMap<Integer,Integer> sloApperanceTable = new HashMap<>();

    public Selector(DBManager manager)
    {
        this.manager=manager;
    }

    public void addSLO(SLO slo)
    {
        sloList.add(slo);
    }

    public int select() throws SQLException {
        for(SLO slo : sloList)
        {
            ArrayList<Integer> list=manager.executeQuery("SELECT * from "
                    +manager.getTableName()
                    +" WHERE "
                    +slo.getValue()
                    +slo.getOperator()
                    +slo.getName());
            for(Integer id :list)
            {
                System.out.println(slo.getName());
                if(sloApperanceTable.containsKey(id))
                {
                    sloApperanceTable.put(id,sloApperanceTable.get(id)+1);
                }

                else
                    sloApperanceTable.put(id,1);
            }

        }
        for (Integer name: sloApperanceTable.keySet()){
            System.out.println(name + " " + sloApperanceTable.get(name));
        }
        return 0;
    }



}
