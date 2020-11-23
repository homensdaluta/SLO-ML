public class Service {

    private String provider;
    private String serviceType;
    private String name;
    private String type;
    private String plan;


    public Service(String provider,String serviceType,String name, String type, String plan)
    {
        this.serviceType=serviceType;
        this.name=name;
        this.type=type;
        this.plan=plan;
        this.provider=provider;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlan() {
        return plan;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
}
