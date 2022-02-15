package com.spring.cache.controller;


import com.spring.cache.modal.RedisPojo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisCacheController {


    @GetMapping(path = "/get-cached-data/{id}")
    @Cacheable(value = "RedisKey", key = "#id")
    public RedisPojo getCachedData(@PathVariable Integer id){
        System.out.println("GetCache Called");
        return new RedisPojo(1, "RedisCached_data"," This is initial Redis Cached Data");
    }

    @PutMapping(path = "/put-cached-data")
    @CachePut(value = "RedisKey", key = "#redisPojo.id" , unless="#result == null")
    public RedisPojo getCachedData(@RequestBody RedisPojo redisPojo){
        System.out.println("PutCache Called");
        return redisPojo;
    }

    @DeleteMapping("/delete-cached-data/{id}")
    @CacheEvict(value= "RedisKey", allEntries = false, key="#id")
    public void removeUser(@PathVariable Integer id) {
        System.out.println("Deleted Cache");
    }

}
