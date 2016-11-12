package com.exorath.service.commons.jedisProvider;

import redis.clients.jedis.JedisPool;

/**
 * Created by toonsev on 11/12/2016.
 */
public interface JedisProvider {
    JedisPool getPool();
}
