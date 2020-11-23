package resource.azure;

public class AzureRMResourceGroup extends Resource{
    /*required arguments*/
    private String name;
    private String location;

    public AzureRMResourceGroup(String resourceName)
    {
        super("azurerm_resource_group",resourceName,2);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        super.addRequired("name","name = \"" + name + "\"\n");
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        addRequired("location","location = \"" + location + "\"\n");
    }

}


