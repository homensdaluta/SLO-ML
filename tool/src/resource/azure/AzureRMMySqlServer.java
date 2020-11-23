package resource.azure;

public class AzureRMMySqlServer extends Resource{
    /*required arguments*/
    private String name;
    private String location;
    private String resourceGroupName;
    private String skuName;
    private String version;
    private String sslEnforcement;
    private String storageProfile;
    private String administratorLogin;
    private String administratorLoginPassword;

    public AzureRMMySqlServer(String resourceName)
    {
        super("azurerm_mysql_server",resourceName,8);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        addRequired("name","name = \"" + name + "\"\n");
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        addRequired("location","location = \"" + location + "\"\n");
    }

    public String getResourceGroupName() {
        return resourceGroupName;
    }

    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
        addRequired("resource_group_name","resource_group_name = \"" + resourceGroupName + "\"\n");
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
        addRequired("sku_name","sku_name = \"" + skuName + "\"\n");
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
        addRequired("version","version = \"" + version + "\"\n");
    }

    public String getSslEnforcement() {
        return sslEnforcement;
    }

    public void setSslEnforcement(String sslEnforcement) {
        this.sslEnforcement = sslEnforcement;
        addRequired("ssl_enforcement","ssl_enforcement = \"" + sslEnforcement + "\"\n");
    }

    public String getStorageProfile() {
        return storageProfile;
    }

    public void setStorageProfile(String storageProfile) {
        this.storageProfile = storageProfile;
        addRequired("storage_profile","storage_profile = " + storageProfile + "\n");
    }

    public String getAdministratorLogin() {
        return administratorLogin;
    }

    public void setAdministratorLogin(String administratorLogin) {
        super.addRequired("administrator_login","administrator_login = \"" + administratorLogin + "\"\n");
        this.administratorLogin = administratorLogin;
    }

    public String getAdministratorLoginPassword() {
        return administratorLoginPassword;
    }

    public void setAdministratorLoginPassword(String administratorLoginPassword) {
        this.administratorLoginPassword = administratorLoginPassword;
        super.addRequired("administrator_login_password","administrator_login_password = \"" + administratorLoginPassword + "\"\n");
    }
}
