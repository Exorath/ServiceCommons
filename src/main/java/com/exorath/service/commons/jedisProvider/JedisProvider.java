package com.exorath.service.commons.jedisProvider;

import redis.clients.jedis.JedisPool;

/**
 * Created by toonsev on 11/12/2016.
 */
public interface JedisProvider {
    JedisPool getPool();

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
