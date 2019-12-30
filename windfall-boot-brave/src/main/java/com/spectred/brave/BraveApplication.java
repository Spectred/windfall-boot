package com.spectred.brave;

import com.spectred.brave.config.RandomProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class BraveApplication {



	public static void main(String[] args) {
		SpringApplication.run(BraveApplication.class, args);
	}

}
