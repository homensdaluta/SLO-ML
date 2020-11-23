package resource.azure;

import resource.azure.Resource;

public class AzureRMCosmosDBAccount extends Resource {
    /*required arguments*/
    private String name;
    private String resourceGroupName;

    public AzureRMCosmosDBAccount(String resourceName)
    {
        super("azurerm_cosmosdb_account",resourceName,2);
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
}
