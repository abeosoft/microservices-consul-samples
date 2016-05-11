package com.abeosoft.microservices.consul.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@Import(value = { SpringDataConfiguration.class, SpringCxfConfiguration.class })
public class NewsServiceApplication extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(NewsServiceApplication.class);

    public static void main(String[] args) {
	ConfigurableApplicationContext context = new NewsServiceApplication().configure(new SpringApplicationBuilder(NewsServiceApplication.class)).run(args);
	logger.debug("Initialized App: " + context.getApplicationName());
    }
}
