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
            int id= selector.select();
            Service test = new Service(
                manager.getSpecific("sla_provider",id),
                manager.getSpecific("sla_service",id),
                manager.getSpecific("sla_name",id),
                manager.getSpecific("sla_type",id),
                manager.getSpecific("sla_plan",id)
            );
            System.out.println(test.getProvider());
            System.out.println(test.getName());
            System.out.println(test.getServiceType());
            System.out.println(test.getType());
            System.out.println(test.getPlan());
            CodeGenerator generator =new CodeGenerator();
            Service tes1 = new Service(
                    manager.getSpecific("sla_provider",8),
                    manager.getSpecific("sla_service",8),
                    manager.getSpecific("sla_name",8),
                    manager.getSpecific("sla_type",8),
                    manager.getSpecific("sla_plan",8)
            );

            Service tes2 = new Service(
                    manager.getSpecific("sla_provider",9),
                    manager.getSpecific("sla_service",9),
                    manager.getSpecific("sla_name",9),
                    manager.getSpecific("sla_type",9),
                    manager.getSpecific("sla_plan",9)
            );
            Service tes3 = new Service(
                    manager.getSpecific("sla_provider",11),
                    manager.getSpecific("sla_service",11),
                    manager.getSpecific("sla_name",11),
                    manager.getSpecific("sla_type",11),
                    manager.getSpecific("sla_plan",11)
            );
            generator.generate(tes3);
            generator.writeBlock();
        }

        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
