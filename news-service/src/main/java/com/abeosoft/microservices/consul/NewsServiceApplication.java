package com.abeosoft.microservices.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.abeosoft.microservices.consul.config.DefaultProperties;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(DefaultProperties.class)
public class NewsServiceApplication {

    public static void main(String[] args) {
	SpringApplication.run(NewsServiceApplication.class, args);
    }
}
