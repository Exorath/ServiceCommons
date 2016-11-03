package com.exorath.service.commons.azureStorageProvider;

import com.microsoft.azure.storage.CloudStorageAccount;

/**
 * Created by toonsev on 11/3/2016.
 */
public interface AzureStorageProvider {
    CloudStorageAccount getAccount();

    static AzureStorageProvider getEnvironmentAzureStorageProvider(){
        return new EnvironmentAzureStorageProvider("AZURE_STORAGE_CONNECTION_STRING");
    }

    static AzureStorageProvider getEnvironmentAzureStorageProvider(String storageConnectionStringEnvKey){
        return new EnvironmentAzureStorageProvider(storageConnectionStringEnvKey);
    }
}
