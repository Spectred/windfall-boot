package com.spectred.hadoop.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FastJson Http Message Converters Config
 *
 * @author SWD
 */
@Configuration(proxyBeanMethods = false)
public class FastJsonHttpMessageConvertersConfig {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters(@Qualifier("fastJsonConfig") FastJsonConfig fastJsonConfig) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(converter);
    }

    @Bean
    public FastJsonConfig fastJsonConfig() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
        return fastJsonConfig;
    }
}
