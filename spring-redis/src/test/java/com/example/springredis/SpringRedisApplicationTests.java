package com.example.springredis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;

@SpringBootTest
class SpringRedisApplicationTests {

    @Test
    void contextLoads() {
    }

    private Jedis jedis;
    @Autowired
    private RedisTemplate redisTemplate;


    @BeforeEach
    void setJedis(){
        Jedis jedis = new Jedis("124.222.91.53",6379);
        jedis.auth("123456");
        jedis.select(0);
    }

    @Test
    void testString(){
      String result =jedis.set("name","小刘");
        System.out.println(result+"=值");
      String name =jedis.get("name");
        System.out.println(name+"=name的值");
   }

   @Test
    void TestHash() {
        jedis.hset("user:1","name","小刘");
        jedis.hset("user:1","name1","小张");

    }

    @Test
    void testString1() {
      redisTemplate.opsForValue().set("name","小刘");
      Object name = redisTemplate.opsForValue().get("name");
      System.out.println("name的值："+name);
  }



}
