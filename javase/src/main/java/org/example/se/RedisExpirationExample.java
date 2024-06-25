package org.example.se;


import org.springframework.context.annotation.Bean;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class RedisExpirationExample {
 
    private static final String HOST = "localhost";
    private static final int PORT = 6379;
 
    public static void main(String[] args) {
        Jedis jedis = new Jedis(HOST, PORT);
        jedis.configSet("notify-keyspace-events","Ex");
        jedis.set("yourKey1", "llll");
        // 设置key的过期时间，并执行方法
        jedis.setex("yourKey1", 10,""); // 10秒后过期
        jedis.setex("yourKey2", 20,""); // 10秒后过期
        System.out.println(jedis.get("yourKey1"));
        // 在另一个线程监听过期事件
        //extracted(jedis);
    }

    @Bean
    private static void extracted(Jedis je) {
        Jedis jedis = new Jedis(HOST, PORT);
        jedis.configSet("notify-keyspace-events","Ex");
        Thread subscriberThread = new Thread(new Runnable() {
            @Override
            public void run() {
                JedisPubSub pubSub = new JedisPubSub() {

                    @Override
                    public void onPMessage(String pattern, String channel, String message) {
                        System.out.println("message = " + message);
                            // 调用方法
                            executeMethod(message);

                    }
                };
                jedis.psubscribe(pubSub, "__keyevent@0__:expired");
            }
        });
        subscriberThread.start();
    }

    private static void executeMethod(String message) {
        // 这里放你要执行的方法
        System.out.println("Key过期了，执行方法！" + message);
    }
}