package com.spectred.brave;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.List;

/**
 * YamlPropertySourceFactory
 *
 * @author SWD
 */
public class YamlPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource encodedResource) throws IOException {
        String sourceName = name != null ? name : encodedResource.getResource().getFilename();
        List<PropertySource<?>> load = new YamlPropertySourceLoader().load(sourceName, encodedResource.getResource());
        return load.get(0);
    }


}
