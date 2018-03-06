package com.xj.xs.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis单机版、集群待改进使用
 * Created by xiong on 2018/3/6.
 */
public class RedisDemo {
    public static void main(String[] args) {
        //单链接
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("123456");
        jedis.set("name","xiong");
        String name = jedis.get("name");
        System.out.println("name: " + name);
        jedis.close();

        jedisPools();
    }

    public static void jedisPools(){
        JedisPoolConfig config = new JedisPoolConfig();
        //设置最大链接数
        config.setMaxTotal(20);
        //设置最大空闲数
        config.setMaxIdle(2);

        JedisPool pool = new JedisPool(config,"127.0.0.1",6379,3000,"123456");
        Jedis jedis = null;

        try {
            jedis = pool.getResource();
            jedis.set("age","25");
            System.out.println("age: " + jedis.get("age"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
