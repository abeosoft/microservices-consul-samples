package com.abeosoft.microservices.consul.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NewsServiceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
	new NewsServiceApplication().configure(new SpringApplicationBuilder(NewsServiceApplication.class)).run(args);
    }
}
