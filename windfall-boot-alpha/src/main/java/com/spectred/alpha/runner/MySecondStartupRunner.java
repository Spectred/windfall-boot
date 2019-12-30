package com.spectred.alpha.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author SWD
 */
@Order(1)
@Component
public class MySecondStartupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        System.out.println("MySecondStartupRunner is running ...");
    }
}
