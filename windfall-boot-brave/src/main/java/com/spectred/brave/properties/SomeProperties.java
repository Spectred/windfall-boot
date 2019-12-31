package com.spectred.brave.properties;

import com.spectred.brave.YamlPropertySourceFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@PropertySource(value = "classpath:config/some.yml", factory = YamlPropertySourceFactory.class)
public class SomeProperties {

    /*
     * 通过@Value读取xml不能直接读取集合
     */

    @Value("${me.name}")
    private String name;

    @Value("${me.age}")
    private Integer age;

    @Value("${me.some.any}")
    private String someAny;

    @Value("${me.urls[0]}")
    private String url0;

    @Value("${me.urls[1]}")
    private String url1;

}


