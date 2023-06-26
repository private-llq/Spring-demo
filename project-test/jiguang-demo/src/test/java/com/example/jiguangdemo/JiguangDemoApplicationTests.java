package com.example.jiguangdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
class JiguangDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testString(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.select(1);
        String result =jedis.set("name","小刘");
        System.out.println(result+"=值");
        String name =jedis.get("name");
        System.out.println(name+"=name的值");
    }


}
