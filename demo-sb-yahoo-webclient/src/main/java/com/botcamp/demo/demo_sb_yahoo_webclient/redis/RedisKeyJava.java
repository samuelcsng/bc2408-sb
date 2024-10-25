package com.botcamp.demo.demo_sb_yahoo_webclient.redis;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
// import java.util.List;

public class RedisKeyJava {

  public static void main(String[] args) {
    try (// Connecting to Redis server on localhost
        Jedis jedis = new Jedis("localhost", 6379)) {
      System.out.println("Connection to server sucessfully");
      // store data in redis list
      // Get the stored data and print it
      // List<String> list = jedis.keys("*");

      // for (int i = 0; i < list.size(); i++) {
      // System.out.println("List of stored keys:: " + list.get(i));
      // // System.out.println("List of stored keys:: " + list);
      // }

      Set<String> list = jedis.keys("*");
      for (String key : list) {
        System.out.println("List of stored keys:: " + key);
        // System.out.println("List of stored keys:: " + jedis.get(key));
      }

      // Get the stored data using the key and print it
      List<String> list2 = jedis.lrange("tutorial-list", 0, -1); // -1 means get all elements
      // List<String> list2 = jedis.lrange("tutorial-name", 0, -1); // -1 means get all elements
      for (String item : list2) {
        System.out.println("Stored string in redis: " + item);
      }
    }
  }

}
