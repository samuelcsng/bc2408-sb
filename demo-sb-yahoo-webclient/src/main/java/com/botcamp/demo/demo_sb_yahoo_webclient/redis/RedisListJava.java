package com.botcamp.demo.demo_sb_yahoo_webclient.redis;

import java.util.List;

import redis.clients.jedis.Jedis;

public class RedisListJava {
  public static void main(String[] args) {
          try (//Connecting to Redis server on localhost 
          Jedis jedis = new Jedis("localhost", 6379)) {
            System.out.println("Connection to server sucessfully"); 
  
            //store data in redis list 
            jedis.lpush("tutorial-list", "Redis"); 
            jedis.lpush("tutorial-list", "Mongodb"); 
            jedis.lpush("tutorial-list", "Mysql"); 
            jedis.lpush("tutorial-list", "Redis"); 
            jedis.lpush("tutorial-list", "Mongodb"); 
            jedis.lpush("tutorial-list", "Mysql"); 
            // Get the stored data and print it 
            List<String> list = jedis.lrange("tutorial-list", 0 ,5); 
  
            for(int i = 0; i<list.size(); i++) { 
               System.out.println("Stored string in redis:: "+list.get(i)); 
            }
          } 
  }
}
