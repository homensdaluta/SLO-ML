package resource.azure;

public class AzureRMSqlDatabase extends Resource{
    /* required arguments*/
    private  String name;
    private String resourceGroupName;
    private String location;
    private String serverName;

    public AzureRMSqlDatabase(String resourceName)
    {
        super("azurerm_sql_database",resourceName,4);
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
        addRequired("resource_group_name","resource_group_name = \"" + resourceGroupName + "\"\n");
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        addRequired("location","location = \"" + location + "\"\n");
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
       addRequired("server_name","server_name = \"" + serverName + "\"\n");
    }

}
