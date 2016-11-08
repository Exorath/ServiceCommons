package com.exorath.service.commons.mongoProvider;

import com.mongodb.MongoClient;

/**
 * Created by toonsev on 11/8/2016.
 */
public interface MongoProvider {
    MongoClient getClient();

    /**
     * Mongo URI must be in the 'MONGO_URI' env variable
     * @return mongoprovider with the 'MONGO_URI' env variable
     */
    static MongoProvider getEnvironmentMongoProvider(){
        return new EnvironmentMongoProvider("MONGO_URI");
    }

    /**
     * Mongo URI must be in the uriEnvName env variable
     * @param uriEnvName the env variable name
     * @return mongoprovider with the uriEnvName env variable
     */
    static MongoProvider getEnvironmentMongoProvider(String uriEnvName){
        return new EnvironmentMongoProvider(uriEnvName);
    }
}
