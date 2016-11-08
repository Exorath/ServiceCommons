package com.exorath.service.commons.mongoProvider;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * Created by toonsev on 11/8/2016.
 */
public class EnvironmentMongoProvider implements MongoProvider{
    private String uriEnvName;

    public EnvironmentMongoProvider(String uriEnvName) {
        this.uriEnvName = uriEnvName;
    }

    @Override
    public MongoClient getClient() {
        String envValue = System.getenv(uriEnvName);
        if(envValue == null || envValue == "")
            throw new IllegalStateException("No " + uriEnvName + " environment variable was provided while trying to load the mongo");
        return new MongoClient(new MongoClientURI(envValue));
    }
}
