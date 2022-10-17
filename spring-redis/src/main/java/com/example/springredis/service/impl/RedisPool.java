//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.springredis.service.impl;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisPool;

public class RedisPool extends JedisPool {
    public RedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout) {
        super(poolConfig, host, port, timeout, (String)null, 0, (String)null);
    }

    public RedisPool(GenericObjectPoolConfig poolConfig, String host, int port, int timeout, String password) {
        super(poolConfig, host, port, timeout, password, 0, (String)null);
    }
}
