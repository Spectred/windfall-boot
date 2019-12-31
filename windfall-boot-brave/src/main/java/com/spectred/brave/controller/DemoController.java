package com.spectred.brave.controller;

import com.spectred.brave.config.MyConfiguration;
import com.spectred.brave.properties.ApplicationCustomProperties;
import com.spectred.brave.properties.RandomProperties;
import com.spectred.brave.properties.SomeProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("demo")
@RestController
public class DemoController {

    @Resource
    private RandomProperties randomProperties;
    @Resource
    private ApplicationCustomProperties customProperties;
    @Resource
    private SomeProperties someProperties;

    @Resource
    private MyConfiguration myConfiguration;

    @GetMapping("/random")
    public RandomProperties randomProperties() {
        return randomProperties;
    }

    @GetMapping("/custom")
    public ApplicationCustomProperties customProperties() {
        return customProperties;
    }

    @GetMapping("/some")
    public SomeProperties someProperties() {
        return someProperties;
    }

    @GetMapping("/my")
    public MyConfiguration my() {
        return myConfiguration;
    }
}
