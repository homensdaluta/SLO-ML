package resource.azure;

import java.util.HashMap;
import java.util.Map;

public class Resource {

    private String type;
    private String name;
    private int numberOfRequired;
    private HashMap<String,String> requiredMap = new HashMap<>();
    private HashMap<String,String> optionalMap = new HashMap<>();

    public Resource(String type,String name, int numberOfRequired)
    {
        this.type=type;
        this.name=name;
        this.numberOfRequired=numberOfRequired;
    }
    public void addRequired(String field,String value)
    {
        requiredMap.put(field,value);
        System.out.println("added");
    }

    public void addOptional(String field,String value)
    {
        optionalMap.put(field,value);
    }

    public String getBlock() {
        String block;
        if(requiredMap.size()==numberOfRequired)
        {
            block = "resource \""+type+"\" \"" + name + "\" { \n";
            for(Map.Entry<String, String> entry : requiredMap.entrySet())
            {
                block+=entry.getValue();
            }
            for(Map.Entry<String, String> entry : optionalMap.entrySet()) {
                block+=entry.getValue();
            }
            block +="}\n";
        }else
            block=" ";
        return block;
    }
}
