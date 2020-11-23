package resource.azure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AzureRMSqlServer extends Resource{

    /*required arguments*/
    private String name ;
    private String resource_group_name;
    private String location;
    private String version;
    private String administrator_login;
    private String administrator_login_password;
    /*optional arguments*/
    private String connection_policy;//TODO:make possible values
    private String identity;//TODO: make a class for identity
    private String extended_auditing_policy;//TODO: make a class for extended_auditing_policy
    private String tags;//TODO: make a class for tags

    public AzureRMSqlServer(String resourceName)
    {
        super("azurerm_sql_server",resourceName,6);
    }

    public String getConnection_policy() {
        return connection_policy;
    }

    public void setConnection_policy(String connection_policy) {
        this.connection_policy = connection_policy;
        super.addOptional("connection_policy","connection_policy = \"" + connection_policy + "\"\n");
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getExtended_auditing_policy() {
        return extended_auditing_policy;
    }

    public void setExtended_auditing_policy(String extended_auditing_policy) {
        this.extended_auditing_policy = extended_auditing_policy;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        super.addRequired("name","name = \"" + name + "\"\n");
        this.name = name;
    }

    public String getResource_group_name() {
        return resource_group_name;
    }

    public void setResource_group_name(String resource_group_name) {
        super.addRequired("resource_group_name","resource_group_name = \"" + resource_group_name + "\"\n");
        this.resource_group_name = resource_group_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
        super.addRequired("location","location = \"" + location + "\"\n");
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
        super.addRequired("version","version = \"" + version + "\"\n");
    }

    public String getAdministrator_login() {
        return administrator_login;
    }

    public void setAdministrator_login(String administrator_login) {
        super.addRequired("administrator_login","administrator_login = \"" + administrator_login + "\"\n");
        this.administrator_login = administrator_login;
    }

    public String getAdministrator_login_password() {
        return administrator_login_password;
    }

    public void setAdministrator_login_password(String administrator_login_password) {
        this.administrator_login_password = administrator_login_password;
        super.addRequired("administrator_login_password","administrator_login_password = \"" + administrator_login_password + "\"\n");
    }
}
