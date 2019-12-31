package com.spectred.creep.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * cors跨域支持
 */
@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        // 允许跨域访问资源定义： /creep/** 所有资源
        corsRegistry.addMapping("/creep/**")
                // 只允许本地的9000端口访问
                .allowedOrigins("http://localhost:8080", "http://127.0.0.1:8080")
                // 允许发送Cookie
                .allowCredentials(true)
                // 允许所有方法
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");

    }
}
