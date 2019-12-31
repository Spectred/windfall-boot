package com.spectred.brave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan({"com.spectred.brave.config"})
@SpringBootApplication
public class BraveApplication {



	public static void main(String[] args) {
		SpringApplication.run(BraveApplication.class, args);
	}

}
