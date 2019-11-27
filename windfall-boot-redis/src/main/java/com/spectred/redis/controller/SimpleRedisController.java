package com.spectred.redis.controller;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Demo For Redis
 *
 * @author SWD
 */
@RestController
@RequestMapping("/simpleRedisClient")
public class SimpleRedisController {

    @Resource(name = "genericFastJsonRedisTemplate")
    private RedisTemplate template;

    @PostMapping(value = "/set")
    public String setValue(@RequestParam("k") String key, @RequestParam("v") String value) {
        ValueOperations<String, String> operations = template.opsForValue();
        operations.set(key, value);
        return operations.get(key);
    }

    @GetMapping("/get/{k}")
    public String getValue(@PathVariable("k") String key) {
        ValueOperations<String, String> operations = template.opsForValue();
        return operations.get(key);
    }


    @PostMapping("/hset")
    public Object hset(@RequestParam("key") String key, @RequestParam("hashKey") Object hashKey, @RequestParam("value") Object value) {

        HashOperations<String, Object, Object> operations = template.opsForHash();
        operations.put(key, hashKey, value);
        return operations.get(key, hashKey);
    }

    @GetMapping("/hget/{key}/{hashKey}")
    public Object hget(@PathVariable("key") String key, @PathVariable("hashKey") Object hashKey) {
        HashOperations<String, Object, Object> operations = template.opsForHash();
        return operations.get(key, hashKey);
    }

    @GetMapping("/baidu")
    public String baidu() {
        return "forward: https://www.baidu.com";
    }


}
