package com.spectred.redis.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

/**
 * @author SWD
 */
@Configuration
public class RedisConfiguration {

    @Bean(name = "genericJacksonRedisTemplate")
    @ConditionalOnMissingBean(name = "genericJacksonRedisTemplate")
    public RedisTemplate<Object, Object> genericJacksonRedisTemplate(RedisConnectionFactory connectionFactory) {
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();

        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setDefaultSerializer(serializer);
        return template;
    }

    @Bean(name = "genericFastJsonRedisTemplate")
    @ConditionalOnMissingBean(name = "genericFastJsonRedisTemplate")
    public RedisTemplate<Object, Object> genericFastJsonRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        GenericFastJsonRedisSerializer serializer = new GenericFastJsonRedisSerializer();

        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(serializer);
        return template;
    }


}
