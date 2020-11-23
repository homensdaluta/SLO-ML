package resource.azure;

public class AzureRMMySqlDatabase extends Resource{
    private String name;
    private String resourceGroupName;
    private String serverName;
    private String charset;
    private String collation;

    public AzureRMMySqlDatabase(String resourceName)
    {
        super("azurerm_mysql_database",resourceName,5);
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

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
        addRequired("server_name","server_name = \"" + serverName + "\"\n");
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
        addRequired("charset","charset = \"" + charset + "\"\n");
    }

    public String getCollation() {
        return collation;
    }

    public void setCollation(String collation) {
        this.collation = collation;
        addRequired("collation","collation = \"" + collation + "\"\n");
    }
}
