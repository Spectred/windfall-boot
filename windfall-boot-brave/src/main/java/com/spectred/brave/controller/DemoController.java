package com.spectred.brave.controller;

import com.spectred.brave.config.ApplicationCustomProperties;
import com.spectred.brave.config.RandomProperties;
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

    @GetMapping("/random")
    public RandomProperties randomProperties() {
        return randomProperties;
    }

    @GetMapping("/custom")
    public ApplicationCustomProperties customProperties() {
        return customProperties;
    }
}
