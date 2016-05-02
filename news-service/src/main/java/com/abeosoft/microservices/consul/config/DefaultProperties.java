package com.abeosoft.microservices.consul.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties("default")
@Data
public class DefaultProperties {

	private String newsSource;
	
}
