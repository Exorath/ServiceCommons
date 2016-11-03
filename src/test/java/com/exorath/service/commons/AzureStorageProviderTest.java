package com.exorath.service.commons;

import com.exorath.service.commons.azureStorageProvider.AzureStorageProvider;
import com.microsoft.azure.storage.CloudStorageAccount;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;

import static org.junit.Assert.assertEquals;

/**
 * Created by toonsev on 11/3/2016.
 */
public class AzureStorageProviderTest {
    @Rule
    public final EnvironmentVariables environmentVariables = new EnvironmentVariables();

    @Test(expected = IllegalStateException.class)
    public void getAccountThrowsIllegalStateExOnGetEnvironmentAzureStorageProviderTest(){
        CloudStorageAccount account = AzureStorageProvider.getEnvironmentAzureStorageProvider().getAccount();
    }
    @Test(expected = IllegalStateException.class)
    public void getAccountThrowsIllegalStateExWithMalformedConnectionStringEnvOnEnvironmentAzureStorageProviderTest(){
        environmentVariables.set("AZURE_STORAGE_CONNECTION_STRING", "str");
        CloudStorageAccount account = AzureStorageProvider.getEnvironmentAzureStorageProvider().getAccount();
    }
    @Test(expected = IllegalStateException.class)
    public void getAccountThrowsIllegalStateExWithWellFormedConnectionStringButMalformedStorageKeyEnvOnEnvironmentAzureStorageProviderTest(){
        String storageConnectionString = "DefaultEndpointsProtocol=http;" + "AccountName=your_storage_account;" + "AccountKey=your_storage_account_key";
        environmentVariables.set("AZURE_STORAGE_CONNECTION_STRING", storageConnectionString);
        CloudStorageAccount account = AzureStorageProvider.getEnvironmentAzureStorageProvider().getAccount();
    }

    @Test
    public void getAccountWithWellFormedConnectionStringEnvDoesNotThrowExceptionOnEnvironmentAzureStorageProviderTest(){
        String storageConnectionString = "DefaultEndpointsProtocol=http;" + "AccountName=your_storage_account;" + "AccountKey=RXhvcmF0aCBpcyBmdW4h";
        environmentVariables.set("AZURE_STORAGE_CONNECTION_STRING", storageConnectionString);
        CloudStorageAccount account = AzureStorageProvider.getEnvironmentAzureStorageProvider().getAccount();
    }

    @Test
    public void getAccountWithWellFormedConnectionStringEnvAccountNameEqualsEnvAccountNameOnEnvironmentAzureStorageProviderTest(){
        String accName = "your_acc_name";
        String storageConnectionString = "DefaultEndpointsProtocol=http;" + "AccountName=" + accName + ";" + "AccountKey=RXhvcmF0aCBpcyBmdW4h";
        environmentVariables.set("AZURE_STORAGE_CONNECTION_STRING", storageConnectionString);
        CloudStorageAccount account = AzureStorageProvider.getEnvironmentAzureStorageProvider().getAccount();
        assertEquals(accName, account.getCredentials().getAccountName());
    }
}
