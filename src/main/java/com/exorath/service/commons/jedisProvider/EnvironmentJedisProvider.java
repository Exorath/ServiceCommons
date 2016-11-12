package com.exorath.service.commons.jedisProvider;


import redis.clients.jedis.JedisPool;

import java.net.URI;

/**
 * Created by toonsev on 11/3/2016.
 */
public class EnvironmentJedisProvider implements JedisProvider {
    private String uriEnvName;

    public EnvironmentJedisProvider(String uriEnvName){
        this.uriEnvName = uriEnvName;
    }

    @Override
    public JedisPool getPool() {
        String envValue = System.getenv(uriEnvName);
        if (envValue == null || envValue == "")
            throw new IllegalStateException("No " + envValue + " environment variable was provided while trying to load the Azure Storage Connection String");
        URI uri = URI.create(envValue);
        return new JedisPool(uri);
    }

    /**
     * Gets a jedisProvider that fetches the redis URI from the REDIS_URI env variable.
     * @return a jedisProvider that fetches the redis URI from the REDIS_URI env variable
     */
    static JedisProvider getEnvironmentAzureStorageProvider(){
        return new EnvironmentJedisProvider("REDIS_URI");
    }
    /**
     * Gets a jedisProvider that fetches the redis URI from the {@param uriEnvName} env variable.
     * @return a jedisProvider that fetches the redis URI from the {@param uriEnvName} env variable
     */
    static JedisProvider getEnvironmentAzureStorageProvider(String uriEnvName){
        return new EnvironmentJedisProvider(uriEnvName);
    }
}
