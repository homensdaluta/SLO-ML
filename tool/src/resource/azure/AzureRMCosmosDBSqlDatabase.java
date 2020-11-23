package resource.azure;

import java.util.ArrayList;

public class AzureRMCosmosDBSqlDatabase extends Resource{
    /*required arguments*/
    private String name;
    private String resourceGroupName;
    private String accountName;
    private String throughput;
    private ArrayList<String> argumentList= new ArrayList<>();

    public AzureRMCosmosDBSqlDatabase(String resourceName)
    {
        super("azurerm_cosmosdb_sql_database",resourceName,4);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        addRequired("name","name = \"" + name + "\"\n");
    }

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
        addRequired("resourceGroupName","resource_group_name = \"" + resourceGroupName + "\"\n");
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
        addRequired("accountName","account_name = \"" + accountName + "\"\n");
    }

    public String getThroughput() {
        return throughput;
    }

    public void setThroughput(String throughput) {
        this.throughput = throughput;
        addRequired("throughput","throughput = " + throughput + "\n");
    }
}
