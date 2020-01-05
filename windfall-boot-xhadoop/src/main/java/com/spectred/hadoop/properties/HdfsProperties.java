package com.spectred.hadoop.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author SWD
 */
@Data
@Component
@ConfigurationProperties("hadoop.hdfs")
public class HdfsProperties {

    private String path;
}
