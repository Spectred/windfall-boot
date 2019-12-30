package com.spectred.leaf;

import com.spectred.leaf.config.CustomProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@SpringBootApplication
public class LeafApplication {
    @Resource
    private CustomProperties customProperties;

    public static void main(String[] args) {
        SpringApplication.run(LeafApplication.class, args);

    }

    @GetMapping("/get")
    public void getProperties() {
        System.out.println(customProperties.getHello());
        System.out.println(customProperties.getList());
    }
}
