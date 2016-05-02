package com.abeosoft.microservices.consul.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abeosoft.microservices.consul.config.DefaultProperties;

@RestController
public class NewsApi {

	@Autowired
	private DefaultProperties newsProperties;
	
	@Autowired
	private Environment env;

	@Value("${spring.application.name:news-app}")
	private String appName;

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/me")
	public ServiceInstance me() {
		return discoveryClient.getLocalServiceInstance();
	}
	
	@RequestMapping("/appName")
	public String appName() {
		return appName;
	}
	
	@RequestMapping("/myenv")
	public String env(@RequestParam("property") String property) {
		return env.getProperty(property, "Not Found");
	}

	@RequestMapping("/newsSource")
	public String newsSource() {
		return newsProperties.getNewsSource();
	}
}
