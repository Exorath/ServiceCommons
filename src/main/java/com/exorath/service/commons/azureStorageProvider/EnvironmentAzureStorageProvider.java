package com.exorath.service.commons.azureStorageProvider;

import com.microsoft.azure.storage.CloudStorageAccount;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

/**
 * Created by toonsev on 11/3/2016.
 */
public class EnvironmentAzureStorageProvider implements AzureStorageProvider {
    private String storageConnectionStringEnvKey;

    public EnvironmentAzureStorageProvider(String storageConnectionStringEnvKey){
        this.storageConnectionStringEnvKey = storageConnectionStringEnvKey;
    }
    @Override
    public CloudStorageAccount getAccount() {
        String envValue = System.getenv(storageConnectionStringEnvKey);
        if (envValue == null || envValue == "")
            throw new IllegalStateException("No " + storageConnectionStringEnvKey + " environment variable was provided while trying to load the Azure Storage Connection String");

        try {
            return CloudStorageAccount.parse(envValue);
        } catch (URISyntaxException | InvalidKeyException | IllegalArgumentException e) {
            throw new IllegalStateException(e);
        }
    }
}
