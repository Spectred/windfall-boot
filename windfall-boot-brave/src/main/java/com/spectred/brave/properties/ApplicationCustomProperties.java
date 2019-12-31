package com.spectred.brave.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "mine")
@Validated //验证该类
public class ApplicationCustomProperties {

    @NotBlank
    private String name;

    private List<String> urls;
}
