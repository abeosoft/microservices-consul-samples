package com.abeosoft.microservices.consul.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Path("/admin")
@Produces({ "application/json" })
public class AdminApi {

    @Autowired
    private Environment env;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GET
    @Path("/whoami")
    public ServiceInstance me() {
	return discoveryClient.getLocalServiceInstance();
    }

    @GET
    @Path("/property")
    public String property(@PathParam("key") String property) {
	return env.getProperty(property, "Not Found");
    }

}
