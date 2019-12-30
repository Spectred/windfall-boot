package com.spectred.brave.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "mine")
public class ApplicationCustomProperties {

    private String name;
}
