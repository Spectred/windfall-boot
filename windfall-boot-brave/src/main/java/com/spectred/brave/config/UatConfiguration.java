package com.spectred.brave.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * 因为扩展了系统属性，需保证唯一性，添加@Primary
 */
@Data
@Primary
@Configuration(proxyBeanMethods = false)
@Profile("uat")
public class UatConfiguration extends ServerProperties {

    @Override
    public Integer getPort() {
        return 8084;
    }
}
