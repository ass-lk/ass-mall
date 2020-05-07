package com.ass.gmall.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis工具包
 */
public class RedisUtil {

    private JedisPool jedisPool;

    public void ininPool(String host,int port,int database){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(200);//设置总数
        config.setMaxIdle(30);
        config.setBlockWhenExhausted(true);
        config.setMaxWaitMillis(10*1000);//设置最大等待时间
        config.setTestOnBorrow(true);
        jedisPool = new JedisPool(config,host,port,20*1000);
    }

    public  Jedis getJedis(){
        Jedis jedis = jedisPool.getResource();
        return  jedis;
    }






}
