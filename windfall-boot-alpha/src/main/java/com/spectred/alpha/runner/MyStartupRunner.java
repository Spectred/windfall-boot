package com.spectred.alpha.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * Spring Boot启动后会执行所有继承CommandLineRunner的类的run方法,以Order标注顺序
 *
 * @author SWD
 */
@Order(0)
@Component
public class MyStartupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyStartupRunner is running ...");
    }
}
