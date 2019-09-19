package com.spectred.web.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 一个简单的Controller
 *
 * @author SWD
 */
@RestController
public class SimpleController {

    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return "Hello," + name;
    }


    @PostMapping("/sayHi")
    public String sayHi(@RequestParam("name") String name) {
        return "Hi," + name;
    }

    @PostMapping("/sayHiJson")
    public String sayHiJson(@RequestBody JSONObject json) {
        return "Hi," + json.getString("name");
    }
}
