package com.spectred.brave.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 * @author SWD
 */
@Data
@Component
@ConfigurationProperties(prefix = "my")
@PropertySource(value = "classpath:config/random.properties")
public class RandomProperties {

    private String secret;

    private int number;

    private long longNumber;

    private String uuid;

    private int range;

    private int lessThan;
}
