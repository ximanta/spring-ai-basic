package com.fk.demos.aidemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "sfg.aiapp")
@Data
public class VectorDbProperties {
    private String vectorStorePath;
    private List<Resource> documentsToLoad;
}
