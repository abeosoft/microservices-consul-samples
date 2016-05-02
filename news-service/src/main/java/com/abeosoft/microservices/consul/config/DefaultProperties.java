package com.abeosoft.microservices.consul.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "news")
public class DefaultProperties {

    // @Value("${default.news.source}")
    private String newsSource;

}
