package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class DemoTest {

    @Test
    public void test1(){
        Map map =new HashMap<>();
        map.put("1","4");
        System.out.println(map.toString());
    }
}
