package com.spectred.brave.config;

import com.spectred.brave.properties.RandomProperties;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(RandomProperties.class)
public class MyConfiguration {

}
