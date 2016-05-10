package com.abeosoft.microservices.consul.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Path("/")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class AdminApi {

    @Autowired
    private Environment env;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GET
    @Path("/health")
    @Produces({ MediaType.TEXT_PLAIN })
    public String healthcheck() {
	// TODO implement a more meaningful health check
	return "UP";
    }

    @GET
    @Path("/whoami")
    public ServiceInstance me() {
	return discoveryClient.getLocalServiceInstance();
    }

    @GET
    @Path("/env/property")
    public String property(@PathParam("key") String property) {
	return env.getProperty(property, "Not Found");
    }

}
