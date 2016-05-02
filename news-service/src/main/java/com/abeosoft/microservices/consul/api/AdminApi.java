package com.abeosoft.microservices.consul.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminApi {

    @Autowired
    private Environment env;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/whoami")
    public ServiceInstance me() {
	return discoveryClient.getLocalServiceInstance();
    }

    @RequestMapping("/property")
    public String property(@RequestParam("key") String property) {
	return env.getProperty(property, "Not Found");
    }

}
