import resource.azure.*;

import java.io.*;

public class CodeGenerator {

    private String generatedCode;
    private String block="";


    public void generate(Service service)
    {
        switch (service.getProvider())
        {
            case "Azure":
                azureServiceList(service);
                break;

        }

    }

    private void azureServiceList(Service service)
    {
        block+="provider \"azurerm\" {\n" +
                "  features {}\n" +
                "}\n";
        switch (service.getServiceType())
        {
            case "Database":
                azureSLANameList(service);
                break;

        }
    }

    private void azureSLANameList(Service service)
    {
        switch (service.getName())
        {
            case "Azure SQL Database":
                generateAzureSQLDB(service);
                break;
            case "Azure Cosmos DB":
                generateAzureCosmosDB(service);
                break;
            case "Azure Database for MySQL":
                generateMySQLDB(service);
                break;


        }
    }

    private void generateAzureSQLDB(Service service)
    {
        /*
        TODO:add optional arguments

         */
        AzureRMResourceGroup resourceGroup = new AzureRMResourceGroup("test");
        resourceGroup.setName("acceptanceTestResourceGroup1");
        resourceGroup.setLocation("West US");
        block+=resourceGroup.getBlock()+"\n";

        AzureRMSqlServer sqlServer = new AzureRMSqlServer("test");
        sqlServer.setName("myexamplesqlserver");
        sqlServer.setResource_group_name(resourceGroup.getName());
        sqlServer.setLocation("West US");
        sqlServer.setVersion("12.0");
        sqlServer.setAdministrator_login("4dm1n157r470r");
        sqlServer.setAdministrator_login_password("4-v3ry-53cr37-p455w0rd");
        block+=sqlServer.getBlock()+"\n";

        AzureRMStorageAccount sqlStorageAcc = new AzureRMStorageAccount("test");
        sqlStorageAcc.setName("examplesa");
        sqlStorageAcc.setLocation("resourceGroup.getName()");
        sqlStorageAcc.setResource_group_name("resourceGroup.getLocation()");
        sqlStorageAcc.setAccountTier("Standard");
        sqlStorageAcc.setAccountReplicationType("LRS");
        block+=sqlStorageAcc.getBlock()+"\n";

        AzureRMSqlDatabase sqlDatabase = new AzureRMSqlDatabase("test");
        sqlDatabase.setName("myexamplesqldatabse");
        sqlDatabase.setLocation("West Us");
        sqlDatabase.setResourceGroupName(resourceGroup.getName());
        sqlDatabase.setServerName(sqlServer.getName());
        block+=sqlDatabase.getBlock()+"\n";
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("test.tf"), "utf-8"))) {
            writer.write(block);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("finnished");

        System.out.println(block);
    }
    private void generateAzureCosmosDB(Service service) {
        /*

        TODO:Missing
         -consistency_policy
         -geo_location
         -location
         -offer_type

         TODO: add optional arguments
        */

        AzureRMCosmosDBAccount cosmosDBAccount = new AzureRMCosmosDBAccount("test");
        cosmosDBAccount.setName("tfex-cosmosdb-account");
        cosmosDBAccount.setResourceGroupName("tfex-cosmosdb-account-rg");
        block+=cosmosDBAccount.getBlock()+"\n";

        AzureRMCosmosDBSqlDatabase cosmosDBSql= new AzureRMCosmosDBSqlDatabase("ronaldo");
        cosmosDBSql.setName("tfex-cosmos-mongo-db");
        cosmosDBSql.setAccountName(cosmosDBAccount.getName());
        cosmosDBSql.setResourceGroupName(cosmosDBAccount.getResourceGroupName());
        cosmosDBSql.setThroughput("1000");
        block+=cosmosDBSql.getBlock();

        System.out.println(block);
    }

    private void generateMySQLDB(Service service) {
        /*
        TODO:Missing
         -storage_profile
        TODO:add optional arguments
         */
        AzureRMResourceGroup resourceGroup = new AzureRMResourceGroup("test");
        resourceGroup.setName("acceptanceTestResourceGroup1");
        resourceGroup.setLocation("West US");
        block+=resourceGroup.getBlock()+"\n";

        AzureRMMySqlServer mySqlServer= new AzureRMMySqlServer("test");
        mySqlServer.setName("postgresql-server-1");
        mySqlServer.setLocation(resourceGroup.getLocation());
        mySqlServer.setResourceGroupName(resourceGroup.getName());
        mySqlServer.setSkuName("B_Gen5_2");
        mySqlServer.setVersion("8.0");
        //mySqlServer.setStorageProfile("5120");
        mySqlServer.setSslEnforcement("Enabled");
        mySqlServer.setAdministratorLogin("mysqladminun");
        mySqlServer.setAdministratorLoginPassword("H@Sh1CoR3!");
        block+=mySqlServer.getBlock()+"\n";

        AzureRMMySqlDatabase mySqlDatabase = new AzureRMMySqlDatabase("test");
        mySqlDatabase.setName("exampledb");
        mySqlDatabase.setResourceGroupName(resourceGroup.getName());
        mySqlDatabase.setServerName(mySqlServer.getName());
        mySqlDatabase.setCharset("utf8");
        mySqlDatabase.setCollation("utf8_unicode_ci");
        block+=mySqlDatabase.getBlock()+"\n";

        System.out.println(block);
    }

    private void generatePostgreSQLDB(Service service) {
        /*
        TODO:add optional arguments
         */
        AzureRMResourceGroup resourceGroup = new AzureRMResourceGroup("test");
        resourceGroup.setName("acceptanceTestResourceGroup1");
        resourceGroup.setLocation("West US");
        block+=resourceGroup.getBlock()+"\n";

        AzureRMPostgreSqlServer mySqlServer= new AzureRMPostgreSqlServer("test");
        mySqlServer.setName("postgresql-server-1");
        mySqlServer.setLocation(resourceGroup.getLocation());
        mySqlServer.setResourceGroupName(resourceGroup.getName());
        mySqlServer.setSkuName("B_Gen5_2");
        mySqlServer.setVersion("8.0");
        //mySqlServer.setStorageProfile("5120");
        mySqlServer.setSslEnforcement("Enabled");
        mySqlServer.setAdministratorLogin("mysqladminun");
        mySqlServer.setAdministratorLoginPassword("H@Sh1CoR3!");
        block+=mySqlServer.getBlock()+"\n";

        AzureRMPostgreSqlDatabase mySqlDatabase = new AzureRMPostgreSqlDatabase("test");
        mySqlDatabase.setName("exampledb");
        mySqlDatabase.setResourceGroupName(resourceGroup.getName());
        mySqlDatabase.setServerName(mySqlServer.getName());
        mySqlDatabase.setCharset("utf8");
        mySqlDatabase.setCollation("utf8_unicode_ci");
        block+=mySqlDatabase.getBlock()+"\n";

        System.out.println(block);
    }
    public void writeBlock()
    {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("test.tf"), "utf-8"))) {
            writer.write(block);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
