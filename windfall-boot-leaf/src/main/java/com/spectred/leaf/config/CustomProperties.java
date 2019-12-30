package com.spectred.leaf.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义属性获取
 *
 * @author SWD
 */
@Data
@Component
@ConfigurationProperties("custom")
public class CustomProperties {

    private String hello;

    private List<String> list;
}
