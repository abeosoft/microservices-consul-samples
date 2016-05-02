package com.abeosoft.microservices.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.abeosoft.microservices.consul.config.DefaultProperties;

@SpringBootApplication
@EnableDiscoveryClient
public class NewsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsServiceApplication.class, args);
	}
	
	@Bean
	public DefaultProperties defaultProperties() {
		return new DefaultProperties();
	}
}
