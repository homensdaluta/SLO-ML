package resource.azure;

public class AzureRMStorageAccount extends Resource{
    /* required arguments*/
    private String name;
    private String resource_group_name;
    private String location;
    private String accountTier;
    private String accountReplicationType;


    public AzureRMStorageAccount(String resourceName)
    {
        super("azurerm_storage_account",resourceName,5);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
       addRequired("name","name = \"" + name + "\"\n");
    }

    public String getResource_group_name() {
        return resource_group_name;
    }

    public void setResource_group_name(String resource_group_name) {
        this.resource_group_name = resource_group_name;
        addRequired("resource_group_name","resource_group_name = \"" + resource_group_name + "\"\n");

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        addRequired("location","location = \"" + location + "\"\n");
    }

    public String getAccountTier() {
        return accountTier;
    }

    public void setAccountTier(String accountTier) {
        this.accountTier = accountTier;
        addRequired("account_tier","account_tier = \"" + accountTier + "\"\n");
    }

    public String getAccountReplicationType() {
        return accountReplicationType;
    }

    public void setAccountReplicationType(String accountReplicationType) {
        this.accountReplicationType = accountReplicationType;
        addRequired("account_replication_type","account_replication_type = \"" + accountReplicationType + "\"\n");
    }

}
