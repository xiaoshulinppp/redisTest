package com.liu.redisTest.redisUntll.method1;

 
import java.util.concurrent.locks.ReadWriteLock;  
import java.util.concurrent.locks.ReentrantReadWriteLock;  
  
import org.apache.ibatis.cache.Cache;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
  
import redis.clients.jedis.Jedis;  
import redis.clients.jedis.JedisPool;  
import redis.clients.jedis.JedisPoolConfig;

public class MybatisRedisCache implements Cache {  
      
    private static Logger logger = LoggerFactory.getLogger(MybatisRedisCache.class);  
    private Jedis redisClient=createReids();  
     /** The ReadWriteLock. */    
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();   
      
    private String id;  
      
    public MybatisRedisCache(final String id) {    
        if (id == null) {  
            throw new IllegalArgumentException("Cache instances require an ID");  
        }  
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id="+id);  
        this.id = id;  
    }    
    public String getId() {  
        return this.id;  
    }  
  
    public int getSize() {  
     
        return Integer.valueOf(redisClient.dbSize().toString());  
    }  
  
    public void putObject(Object key, Object value) {  
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>putObject:"+key+"="+value);  
        redisClient.set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));  
    }  
  
    public Object getObject(Object key) {  
        Object value = SerializeUtil.unserialize(redisClient.get(SerializeUtil.serialize(key.toString())));  
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>getObject:"+key+"="+value);  
        return value;  
    }  
  
    public Object removeObject(Object key) {  
        return redisClient.expire(SerializeUtil.serialize(key.toString()),0);  
    }  
  
    public void clear() {  
          redisClient.flushDB();  
    }  
    public ReadWriteLock getReadWriteLock() {  
        return readWriteLock;  
    }  
    protected  static Jedis createReids(){  
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379,10000);  
        return pool.getResource();  
    }  
}