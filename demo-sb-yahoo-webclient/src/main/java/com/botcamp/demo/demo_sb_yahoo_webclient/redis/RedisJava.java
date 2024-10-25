package com.botcamp.demo.demo_sb_yahoo_webclient.redis;

import redis.clients.jedis.Jedis;

public class RedisJava {

  public static void main(String[] args) {

      try (//Connecting to Redis server on localhost 
      Jedis jedis = new Jedis("localhost", 6379)) {
        System.out.println("Connection to server sucessfully");
        // check whether server is running or not
        System.out.println("Server is running: " + jedis.ping());
      }



  }
}


