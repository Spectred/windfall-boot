package com.spectred.hadoop.config;

import com.spectred.hadoop.properties.HdfsProperties;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class HadoopConfig {

    @Resource
    private HdfsProperties hdfsProperties;

    @Bean
    public FileSystem fileSystem() throws URISyntaxException, IOException, InterruptedException {
        org.apache.hadoop.conf.Configuration configuration = new org.apache.hadoop.conf.Configuration();
        return FileSystem.get(new URI(hdfsProperties.getPath()), configuration, "root");
    }
}
